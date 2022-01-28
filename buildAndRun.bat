@ECHO OFF
ECHO Running new build for jpa
CALL  mvn clean package
ECHO Building a new image with docker build -t io.jotech/jpa .
CALL  docker build -t io.jotech/jpa .
ECHO Recreating the deployment container
CALL  docker-compose up -d
ECHO Showing logs...
docker logs -f web
Echo Done!