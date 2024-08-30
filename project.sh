#!/bin/bash

# compiler Edilsin
mvn clean package -DskipTests

#docker-compose up
#docker-compose -f mysql_docker-compose up -d
docker-compose up -d