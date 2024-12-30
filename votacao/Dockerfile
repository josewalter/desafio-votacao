FROM openjdk:24-ea-17-slim
WORKDIR /app
COPY target/*.jar /app/votacao.jar
EXPOSE 8080
CMD ["java", "-jar", "votacao.jar"]