#!/bin/bash
echo "Spring Boot - Mysql"

# mvn clean package
# mvn clean package -DskipTests

docker-compose -f mysql_docker-compose.yml up -d