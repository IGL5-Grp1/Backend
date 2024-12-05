# Use OpenJDK 21 with Alpine for a lightweight base image
FROM openjdk:21-jdk-slim

# Expose the application's default port
EXPOSE 8081

# Copy the built JAR file directly into the container
ADD target/gestion-examens-0.0.1-SNAPSHOT.jar app.jar

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app.jar"]