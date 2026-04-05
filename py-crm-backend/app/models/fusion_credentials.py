from sqlalchemy import String, Boolean
from sqlalchemy.orm import Mapped, mapped_column

from app.db.base_class import Base


class FusionCredentials(Base):
    __tablename__ = "fusion_credentials"

    row_id: Mapped[int] = mapped_column(primary_key=True, autoincrement=True)
    active: Mapped[str] = mapped_column(String(1), default="Y")
    host_name: Mapped[str] = mapped_column(String(255), unique=True)
    password: Mapped[str] = mapped_column(String(255))
    server: Mapped[str] = mapped_column(String(10))
    username: Mapped[str] = mapped_column(String(255))
