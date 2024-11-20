# Use a Java runtime as the base image
FROM eclipse-temurin:21-jre-alpine

# Install curl for testing purposes using apk (Alpine package manager)
RUN apk add --no-cache curl

# Set the working directory in the container
WORKDIR /app

# Copy the application jar to the container
COPY target/service-notification-1.0.0.jar service-notification.jar

# Copy the wait script
COPY wait-for-config-server.sh /app/wait-for-config-server.sh
RUN chmod +x /app/wait-for-config-server.sh

# Expose the port (use the same port as defined in your application.yml or as needed)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["/app/wait-for-config-server.sh", "java", "-jar", "/app/service-notification.jar"]
