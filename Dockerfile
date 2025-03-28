# Базовый образ с Maven и OpenJDK 17
FROM maven:3.8.4-openjdk-17 AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем исходный код и pom.xml
COPY src ./src
COPY pom.xml .

# Устанавливаем зависимости для UI тестов (браузеры и драйверы)
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    google-chrome-stable \
    && wget -N https://chromedriver.storage.googleapis.com/$(curl -sS https://chromedriver.storage.googleapis.com/LATEST_RELEASE)/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip \
    && chmod +x chromedriver \
    && mv -f chromedriver /usr/local/bin/chromedriver \
    && rm chromedriver_linux64.zip

# Запуск тестов
CMD ["mvn", "clean", "test"]