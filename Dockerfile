# Usa un'immagine che ha già Maven e Java 17 per compilare
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

# Copia i file di configurazione di Maven (pom.xml) e scarica le dipendenze
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia il codice sorgente e crea il file .jar (saltando i test per velocità)
COPY src ./src
RUN mvn clean package -DskipTests

# Fase 2: Crea l'immagine finale "leggera" che farà solo girare il jar
FROM openjdk:17-jdk-slim
WORKDIR /app

# Prende il file .jar generato nella fase precedente e lo copia
COPY --from=build /app/target/*.jar app.jar

# Espone la porta 8080 (quella standard di Spring)
EXPOSE 8080

# Comando per avviare l'applicazione
ENTRYPOINT ["java", "-jar", "app.jar"]