# FROM
# https://hub.docker.com/_/openjdk
# ( Docker Debian )
FROM openjdk:14-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Clone
COPY ./target/demospring-0.0.1-SNAPSHOT.jar .

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run .jar when the container launches
CMD ["java", "-jar", "-Dspring.profiles.active=docker", "./demospring-0.0.1-SNAPSHOT.jar"]