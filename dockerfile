# Use an official Maven image as the base image
FROM maven:3.9.9 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and any other necessary files for dependency resolution
COPY pom.xml ./

# Download dependencies without building the project
RUN mvn dependency:go-offline -B

# Copy the rest of the application source code
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Use a lightweight JDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged application from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port (adjust as needed)
EXPOSE 8080

# Set the default command to run the application
CMD ["java", "-jar", "app.jar"]