# Use OpenJDK 21 as base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml first (for better Docker layer caching)
COPY mvnw mvnw.cmd pom.xml ./
COPY .mvn .mvn

# Download dependencies (this layer will be cached if pom.xml doesn't change)
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the application with production profile
CMD ["java", "-jar", "target/TotoRails-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=prod"]
