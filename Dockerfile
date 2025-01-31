FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR file into the container

COPY target/employee-0.0.1-SNAPSHOT.jar app.jar


# Expose the port your app runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
