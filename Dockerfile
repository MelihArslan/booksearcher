# Use the official OpenJDK 17 base image
FROM openjdk:17.0.1-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/booksearcher-0.0.1-SNAPSHOT.jar /app

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Specify the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "booksearcher-0.0.1-SNAPSHOT.jar"]
