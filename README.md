# Elasticsearch

`docker-compose up -d` will start the web and ES container

`docker-compose down` will clean up the containers and network

To populate the data

1. Make sure the Docker container for Elasticsearch is running. See [https://bitbucket.org/readyplay/dev-deployment/src/master/README.md]().
1. Run the following

	```
	docker run -it --rm --link elasticsearch --mount type=bind,src=$( pwd ),dst=/data --network dev-deployment_internal python:3.7-alpine /data/scripts/docker_populate_data.sh`
	```