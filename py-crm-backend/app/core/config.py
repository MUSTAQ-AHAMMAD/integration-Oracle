from functools import lru_cache
from typing import List, Optional

from pydantic_settings import BaseSettings
from pydantic import Field, AnyUrl


class Settings(BaseSettings):
    app_name: str = "integration-oracle-python"
    environment: str = "local"
    debug: bool = False
    api_prefix: str = "/api"

    database_url: AnyUrl = Field(..., env="DATABASE_URL")
    redis_url: Optional[str] = Field(default=None, env="REDIS_URL")

    fusion_host: Optional[str] = Field(default=None, env="FUSION_HOST")
    fusion_server: Optional[str] = Field(default=None, env="FUSION_SERVER")
    fusion_username: Optional[str] = Field(default=None, env="FUSION_USERNAME")
    fusion_password: Optional[str] = Field(default=None, env="FUSION_PASSWORD")

    vendhq_domain: Optional[str] = Field(default=None, env="VENDHQ_DOMAIN")
    vendhq_token: Optional[str] = Field(default=None, env="VENDHQ_TOKEN")

    cors_origins: List[str] = Field(default_factory=lambda: ["http://localhost:5173"], env="CORS_ORIGINS")

    log_level: str = Field(default="INFO", env="LOG_LEVEL")
    metrics_enabled: bool = Field(default=True, env="METRICS_ENABLED")

    class Config:
        env_file = ".env"
        env_file_encoding = "utf-8"
        extra = "ignore"


@lru_cache
def get_settings() -> Settings:
    return Settings()
