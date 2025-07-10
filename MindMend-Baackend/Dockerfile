FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY src .
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["java","-jar","target/mindmend-backend-0.1.0.jar","--server.port=${PORT}"]
