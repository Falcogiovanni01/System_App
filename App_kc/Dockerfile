FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Usa l'asterisco così se cambi versione non devi toccare il Dockerfile
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]