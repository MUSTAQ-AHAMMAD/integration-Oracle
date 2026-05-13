"""
Vyrooq Workflow Engine Configuration
"""

from pydantic_settings import BaseSettings
from typing import List


class Settings(BaseSettings):
    """Application settings loaded from environment variables"""

    # Temporal Configuration
    temporal_host: str = "localhost:7233"
    temporal_namespace: str = "default"
    temporal_task_queue: str = "vyrooq-sales-processing"

    # Database Configuration
    database_url: str = "postgresql://postgres:vyrooq123@localhost:5432/vyrooq"

    # Redis Configuration
    redis_url: str = "redis://localhost:6379"

    # Kafka Configuration
    kafka_brokers: List[str] = ["localhost:9092"]

    # Oracle Fusion Configuration
    fusion_base_url: str = ""
    fusion_username: str = ""
    fusion_password: str = ""

    # VendHQ Configuration
    vendhq_api_url: str = ""
    vendhq_api_token: str = ""

    # Processing Configuration
    max_retry_attempts: int = 50
    retry_backoff_seconds: int = 60

    # Environment
    environment: str = "development"
    log_level: str = "INFO"

    class Config:
        env_file = ".env"
        case_sensitive = False


settings = Settings()
