FROM openjdk:17.0.2-jdk-slim

WORKDIR /app

COPY build/libs/movie-ms.jar app.jar



CMD ["java", "-jar", "app.jar"]
