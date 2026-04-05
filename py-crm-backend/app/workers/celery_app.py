import os

from celery import Celery

from app.core.config import get_settings

settings = get_settings()

celery_app = Celery(
    "integration-oracle-python",
    broker=settings.redis_url,
    backend=settings.redis_url,
)

celery_app.conf.task_routes = {"app.workers.tasks.*": {"queue": "default"}}
celery_app.conf.timezone = "UTC"
celery_app.conf.worker_max_tasks_per_child = 100


@celery_app.task(name="app.workers.tasks.health")
def health_task() -> str:
    return "ok"
