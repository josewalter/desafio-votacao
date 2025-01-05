FROM openjdk:24-ea-17-slim
WORKDIR /app
COPY target/*.jar /app/votacao-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "votacao-0.0.1-SNAPSHOT.jar"]