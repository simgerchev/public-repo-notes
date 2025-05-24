### Accessing the Frontend Container Shell

To open an interactive shell (`sh`) session inside the running **React frontend container**, use the following Docker command:

```bash
docker exec -it <container-name> sh/bash
```

### Build the Image again

To build the image again or rebuild it use this command:

```bash
docker-compose build --no-cache
```

### Build the Image again

To start all containers using the currently built image and the docker-compose file use this command:

```bash
docker-compose up
```
