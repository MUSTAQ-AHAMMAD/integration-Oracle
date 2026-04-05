from typing import List, Optional

from sqlalchemy import select
from sqlalchemy.ext.asyncio import AsyncSession

from app.core.security import verify_password, get_password_hash
from app.models.user import User
from app.models.role import Role
from app.models.user_role import UserRole


async def get_user_by_email(session: AsyncSession, email: str) -> Optional[User]:
    result = await session.execute(select(User).where(User.email == email))
    return result.scalars().first()


async def ensure_roles(session: AsyncSession, role_names: List[str]) -> List[Role]:
    roles: List[Role] = []
    for name in role_names:
        result = await session.execute(select(Role).where(Role.name == name))
        role = result.scalars().first()
        if not role:
            role = Role(name=name)
            session.add(role)
        roles.append(role)
    return roles


async def create_user(session: AsyncSession, email: str, password: str, full_name: str | None, roles: List[str], is_superuser: bool = False) -> User:
    db_user = User(
        email=email,
        full_name=full_name,
        hashed_password=get_password_hash(password),
        is_superuser=is_superuser,
    )
    session.add(db_user)
    role_objs = await ensure_roles(session, roles)
    await session.flush()
    for role in role_objs:
        session.add(UserRole(user_id=db_user.id, role_id=role.id))
    await session.commit()
    await session.refresh(db_user)
    return db_user


async def authenticate_user(session: AsyncSession, email: str, password: str) -> Optional[User]:
    user = await get_user_by_email(session, email)
    if not user or not verify_password(password, user.hashed_password):
        return None
    return user
