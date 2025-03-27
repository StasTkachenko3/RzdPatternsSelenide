# Используем образ Maven с OpenJDK для сборки и запуска тестов
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY src ./src
COPY pom.xml .
CMD ["mvn", "clean", "test"]