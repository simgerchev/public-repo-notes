
# Dockerize Your Django Project

This guide walks you through the steps to dockerize a Django project.

---

## Step 1: Set Up Your Django Project

### 1. Initialize a Django Project
```bash
django-admin startproject my_docker_django_app
cd my_docker_django_app
```

### 2. Create a requirements.txt File
```bash
pip freeze > requirements.txt
```

### 3. Update Key Environment Settings
In `settings.py`, modify the following:

```python
import os

SECRET_KEY = os.environ.get("SECRET_KEY")
DEBUG = bool(os.environ.get("DEBUG", default=0))
ALLOWED_HOSTS = os.environ.get("DJANGO_ALLOWED_HOSTS", "127.0.0.1").split(",")
```

---

## Step 2: Create a Dockerfile

### Basic Dockerfile for Development
```Dockerfile
FROM python:3.13

RUN mkdir /app
WORKDIR /app

ENV PYTHONDONTWRITEBYTECODE=1
ENV PYTHONUNBUFFERED=1

RUN pip install --upgrade pip
COPY requirements.txt /app/
RUN pip install --no-cache-dir -r requirements.txt
COPY . /app/

EXPOSE 8000

CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]
```

### Build and View Image
```bash
docker build -t django-docker .
docker image list
```

---

## Step 3: Optimize Dockerfile for Production

### Update `requirements.txt`
```text
asgiref==3.8.1
Django==5.1.3
sqlparse==0.5.2
gunicorn==23.0.0
psycopg2-binary==2.9.10
```

### Production-ready Dockerfile
```Dockerfile
# Stage 1: Builder
FROM python:3.13-slim AS builder

RUN mkdir /app
WORKDIR /app

ENV PYTHONDONTWRITEBYTECODE=1
ENV PYTHONUNBUFFERED=1

RUN pip install --upgrade pip
COPY requirements.txt /app/
RUN pip install --no-cache-dir -r requirements.txt

# Stage 2: Production
FROM python:3.13-slim

RUN useradd -m -r appuser && mkdir /app && chown -R appuser /app

COPY --from=builder /usr/local/lib/python3.13/site-packages/ /usr/local/lib/python3.13/site-packages/
COPY --from=builder /usr/local/bin/ /usr/local/bin/

WORKDIR /app
COPY --chown=appuser:appuser . .

ENV PYTHONDONTWRITEBYTECODE=1
ENV PYTHONUNBUFFERED=1

USER appuser

EXPOSE 8000

CMD ["gunicorn", "--bind", "0.0.0.0:8000", "--workers", "3", "my_docker_django_app.wsgi:application"]
```

---

## Step 4: Configure Docker Compose

### `compose.yml`
```yaml
services:
  db:
    image: postgres:17
    environment:
      POSTGRES_DB: ${DATABASE_NAME}
      POSTGRES_USER: ${DATABASE_USERNAME}
      POSTGRES_PASSWORD: ${DATABASE_PASSWORD}
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    env_file:
      - .env

  django-web:
    build: .
    container_name: django-docker
    ports:
      - "8000:8000"
    depends_on:
      - db
    environment:
      DJANGO_SECRET_KEY: ${DJANGO_SECRET_KEY}
      DEBUG: ${DEBUG}
      DJANGO_LOGLEVEL: ${DJANGO_LOGLEVEL}
      DJANGO_ALLOWED_HOSTS: ${DJANGO_ALLOWED_HOSTS}
      DATABASE_ENGINE: ${DATABASE_ENGINE}
      DATABASE_NAME: ${DATABASE_NAME}
      DATABASE_USERNAME: ${DATABASE_USERNAME}
      DATABASE_PASSWORD: ${DATABASE_PASSWORD}
      DATABASE_HOST: ${DATABASE_HOST}
      DATABASE_PORT: ${DATABASE_PORT}
    env_file:
      - .env

volumes:
  postgres_data:
```

### `.env` Example
```dotenv
DJANGO_SECRET_KEY=your_secret_key
DEBUG=True
DJANGO_LOGLEVEL=info
DJANGO_ALLOWED_HOSTS=localhost
DATABASE_ENGINE=postgresql_psycopg2
DATABASE_NAME=dockerdjango
DATABASE_USERNAME=dbuser
DATABASE_PASSWORD=dbpassword
DATABASE_HOST=db
DATABASE_PORT=5432
```

---

## Step 5: Update Django Settings

### Database Settings
```python
DATABASES = {
    'default': {
        'ENGINE': 'django.db.backends.{}'.format(os.getenv('DATABASE_ENGINE', 'sqlite3')),
        'NAME': os.getenv('DATABASE_NAME', 'polls'),
        'USER': os.getenv('DATABASE_USERNAME', 'myprojectuser'),
        'PASSWORD': os.getenv('DATABASE_PASSWORD', 'password'),
        'HOST': os.getenv('DATABASE_HOST', '127.0.0.1'),
        'PORT': os.getenv('DATABASE_PORT', 5432),
    }
}
```

### ALLOWED_HOSTS
```python
ALLOWED_HOSTS = os.environ.get("DJANGO_ALLOWED_HOSTS", "127.0.0.1").split(",")
```

### SECRET_KEY
```python
SECRET_KEY = os.environ.get("DJANGO_SECRET_KEY")
```

### DEBUG
```python
DEBUG = bool(os.environ.get("DEBUG", default=0))
```

---

## Step 6: Build and Run

### Build and Start Containers
```bash
docker compose up --build
```

### Test the Application
Visit: [http://localhost:8000](http://localhost:8000)

### Run Migrations
```bash
docker compose run django-web python manage.py migrate
```
