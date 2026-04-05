from datetime import datetime
from typing import List, Optional

from pydantic import BaseModel, EmailStr


class RoleBase(BaseModel):
    name: str
    description: Optional[str] = None


class RoleOut(RoleBase):
    id: int

    class Config:
        from_attributes = True


class UserBase(BaseModel):
    email: EmailStr
    full_name: Optional[str] = None
    is_active: bool = True


class UserCreate(UserBase):
    password: str
    roles: List[str] = []
    is_superuser: bool = False


class UserOut(UserBase):
    id: int
    is_superuser: bool
    created_at: datetime
    updated_at: datetime
    roles: List[RoleOut] = []

    class Config:
        from_attributes = True


class Token(BaseModel):
    access_token: str
    refresh_token: str
    token_type: str = "bearer"


class TokenPayload(BaseModel):
    sub: str
    exp: int
    type: str
