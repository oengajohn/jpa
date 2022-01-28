#!/bin/sh
echo "Running new build for jpa project"
mvn clean package
echo "Building a new image with docker build -t io.jotech/jpa ."
docker build -t io.jotech/jpa .
echo "Recreating the deployment container"
docker-compose up -d
echo "Showing logs..."
docker logs -f web
echo "Done!"