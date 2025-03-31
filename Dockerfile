# Базовый образ с Maven и OpenJDK 17
# Используем официальный образ Maven с OpenJDK 17 на Debian
FROM maven:3.8.4-openjdk-17-slim AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем исходный код и pom.xml
COPY src ./src
COPY pom.xml .

# Устанавливаем зависимости для UI-тестов (Chrome + Chromedriver)
RUN apt-get update && apt-get install -y --no-install-recommends \
    wget \
    unzip \
    gnupg \
    && wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && CHROME_DRIVER_VERSION=$(curl -sS https://chromedriver.storage.googleapis.com/LATEST_RELEASE) \
    && wget -N https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip \
    && unzip chromedriver_linux64.zip \
    && chmod +x chromedriver \
    && mv chromedriver /usr/local/bin/ \
    && rm chromedriver_linux64.zip \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Запуск тестов
CMD ["mvn", "clean", "test"]
