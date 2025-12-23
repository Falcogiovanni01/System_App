# System_App
per compilare l'app: 
mvn clean package -DskipTests

per compilare i container:
docker-compose build
per avviare il container:
docker-compose up -d


accedere al seguente link: 
https://localhost:8443/home
admin keycloack: 
https://localhost:8443/admin/master/console/
per accedere a vault: 
https://localhost:9443/ui

Se volete eseguire l'app, dovrete collegarvi a vault oppure aggiungete nel container qualcosa del genere:
VAULT_TOKEN=******

#MONGO DB
MONGO_ROOT_PASSWORD=******
MONGO_INITDB_ROOT_PASSWORD =******
MONGO_USERNAME=******
MONGO_PASSWORD=******
#KEYCLOACK
KEYCLOACK_PASSWORD=******
KEYCLOACK_CLIENT_SECRET=******

#APP SECRET
APP_SECRET=******

sono i token/codici che vengono usati per collegare l'app a keycloak o ad altri sistemi. 
dovete creare un file .env e poi inserire i vostri ovviamente.
es: KEYCLOACK_CLIENT_SECRET andate nel realm e create un nuovo realm e dà li avrete accesso al client secret
fate copia e incolla e il gioca e fatto.
