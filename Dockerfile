FROM openjdk:17.0.2-jdk-slim

WORKDIR /app

COPY build/libs/movie-ms.jar app.jar


# Configuración de la base de datos
DATABASE_URL=${RAILWAY_DATABASE_URL}
DATABASE_USERNAME=${RAILWAY_DATABASE_USERNAME}
DATABASE_PASSWORD=${RAILWAY_DATABASE_PASSWORD}


CMD ["java", "-jar", "app.jar"]
