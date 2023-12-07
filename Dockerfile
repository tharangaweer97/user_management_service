 #Docker image for a Java application
 #base image for your Docker image
FROM openjdk:17-jdk-slim
#build argument for the JAR file
ARG JAR_FILE=target/*.jar
# Copy the JAR file into the image
COPY ${JAR_FILE} application.jar
EXPOSE 8080
#Set the entry point for the container & command runs the Java application using the specified JAR file
ENTRYPOINT ["java", "-Duser.timezone=UTC", "-jar", "application.jar"]


