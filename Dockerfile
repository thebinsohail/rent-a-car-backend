FROM openjdk:latest
ADD target/renta-docker.jar renta-docker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","renta-docker.jar"]