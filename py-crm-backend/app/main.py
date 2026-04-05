import uvicorn
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from prometheus_fastapi_instrumentator import Instrumentator

from app.db.session import get_db
from app.services.auth import get_user_by_email, create_user
from app.api.v1.router import api_router
from app.core.config import get_settings
from app.utils.logging import configure_logging
from app.workers.scheduler import start_scheduler, stop_scheduler


def get_app() -> FastAPI:
    settings = get_settings()
    configure_logging(settings.log_level)

    app = FastAPI(
        title=settings.app_name,
        debug=settings.debug,
        version="0.1.0",
    )

    app.add_middleware(
        CORSMiddleware,
        allow_origins=settings.cors_origins,
        allow_credentials=True,
        allow_methods=["*"],
        allow_headers=["*"],
    )

    app.include_router(api_router, prefix=settings.api_prefix)

    if settings.metrics_enabled:
        Instrumentator().instrument(app).expose(app, include_in_schema=False)

    @app.on_event("startup")
    async def seed_admin() -> None:
        start_scheduler()
        async for session in get_db():
            existing = await get_user_by_email(session, "admin@example.com")
            if not existing:
                await create_user(
                    session,
                    email="admin@example.com",
                    password="admin123",
                    full_name="Admin",
                    roles=["Admin"],
                    is_superuser=True,
                )

    @app.on_event("shutdown")
    async def shutdown_events() -> None:
        stop_scheduler()

    return app


app = get_app()


if __name__ == "__main__":
    uvicorn.run("app.main:app", host="0.0.0.0", port=8000, reload=True)
