FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/ms-order-*.jar ms-order.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "ms-order.jar"]