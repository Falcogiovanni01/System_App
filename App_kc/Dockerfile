#1. Usa un'immagine base MINIMALE (Alpine Linux)
FROM eclipse-temurin:21-jre-alpine

#2. Crea un gruppo e un utente NON-ROOT
# (NIST SI-7: Least Privilege)
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /app
# Usa l'asterisco così se cambi versione non devi toccare il Dockerfile
COPY target/*.jar app.jar

# 5. Cambia proprietario del file all'utente non-root
RUN chown appuser:appgroup app.jar

# 6. Passa all'utente limitato
# Da qui in poi, nessun comando girerà come Root
USER appuser

ENTRYPOINT ["java", "-jar", "app.jar"]