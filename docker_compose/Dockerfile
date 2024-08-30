# Image
FROM openjdk:21

# ARG
#ARG JAR_FILE=*.jar
ARG JAR_FILE=h2db_spring.jar

# ADD
ADD ${JAR_FILE} blog.jar

# ENTRYPOINT
ENTRYPOINT ["java", "-jar","/blog.jar"]

########################################################
# docker build -t imageName .
# docker build -f CustomizeDockerFile -t imageName .

# docker container ls
# docker container ls -a
# docker ps
# docker ps -a
# docker container run -p 2222:4444 blog
# docker container run -p 3333:4444 --name malatya blog
# docker container run -d -p 5555:4444 --name malatya2 blog
# docker container run --rm -d -p 6666:4444 --name malatya3 blog
# docker container prune

# docker container exec -it containerID bash
