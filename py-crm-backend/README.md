# Python CRM Backend (FastAPI)

## Prerequisites
- Python 3.11+
- PostgreSQL (recommended) or any SQLAlchemy-supported DB
- Redis (for Celery)

## Setup (Windows)
```powershell
cd py-crm-backend
python -m venv .venv
.venv\\Scripts\\activate
python -m pip install --upgrade pip
pip install -r requirements.txt
```

## Environment
Copy `.env.example` to `.env` and set values:
```
DATABASE_URL=postgresql+asyncpg://user:pass@localhost:5432/integration
REDIS_URL=redis://localhost:6379/0
FUSION_HOST=your-host
FUSION_SERVER=your-server
FUSION_USERNAME=user
FUSION_PASSWORD=pass
VENDHQ_DOMAIN=your-domain
VENDHQ_TOKEN=api-key
LOG_LEVEL=INFO
```

## Run
```powershell
uvicorn app.main:app --reload --host 0.0.0.0 --port 8000
```

## Migrations
```powershell
alembic revision --autogenerate -m "init"
alembic upgrade head
```

## Celery
```powershell
celery -A app.workers.celery_app worker --loglevel=info
celery -A app.workers.celery_app beat --loglevel=info
```
