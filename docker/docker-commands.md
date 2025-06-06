### Accessing the Frontend Container Shell

To open an interactive shell (`sh`) session inside the running **React frontend container**, use the following Docker command:

```bash
docker exec -it <container-name> sh/bash
```

### Build/Rebuild the Image

To build the image or rebuild it use this command:

```bash
docker-compose build --no-cache
```

### Run the container

To start all containers using the currently built image and the docker-compose file use this command:

```bash
docker-compose up
```

### Remove containers, volumes, images, and orphans

```bash
docker-compose down --volumes --rmi all --remove-orphans

docker system prune -a --volumes
```

### Prune unused Docker data

```bash
docker system prune -a
```

> **Warning:** These commands will delete all stopped containers, unused networks, dangling images, and volumes. Make sure you don’t need them before running these.
