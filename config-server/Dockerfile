# Use a Java runtime as the base image
FROM eclipse-temurin:21-jre-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the application jar to the container
COPY target/config-server-1.0.0.jar config-server.jar

# Expose the port (use the same port as defined in your application.yml or as needed)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/config-server.jar"]
