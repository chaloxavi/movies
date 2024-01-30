FROM openjdk:17.0.2-jdk-slim

WORKDIR /app

COPY build/libs/movie-ms.jar app.jar


# Configuración de la base de datos
spring.datasource.url=${RAILWAY_DATABASE_URL}
spring.datasource.username=${RAILWAY_DATABASE_USERNAME}
spring.datasource.password=${RAILWAY_DATABASE_PASSWORD}


CMD ["java", "-jar", "app.jar"]
