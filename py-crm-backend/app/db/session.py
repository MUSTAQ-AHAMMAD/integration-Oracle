from typing import AsyncGenerator

from sqlalchemy.ext.asyncio import async_sessionmaker, create_async_engine, AsyncSession

from app.core.config import get_settings

settings = get_settings()

engine = create_async_engine(
    settings.database_url.unicode_string(),  # type: ignore[arg-type]
    pool_pre_ping=True,
    future=True,
)
SessionLocal = async_sessionmaker(autocommit=False, autoflush=False, bind=engine, expire_on_commit=False)


async def get_db() -> AsyncGenerator[AsyncSession, None]:
    async with SessionLocal() as session:
        yield session
