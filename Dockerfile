# Use Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Copy jar file
COPY target/*.jar app.jar

# Run application
ENTRYPOINT ["java","-jar","/app.jar"]
