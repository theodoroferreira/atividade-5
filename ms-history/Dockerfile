FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/ms-history-*.jar ms-history.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "ms-history.jar"]