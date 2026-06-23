# ===================== ÉTAPE 1 : BUILD =====================
# On utilise une image Maven avec Java 17 pour compiler le projet
FROM maven:3.9.6-eclipse-temurin-17 AS build

# On définit le dossier de travail à l'intérieur du conteneur
WORKDIR /app

# On copie d'abord uniquement le pom.xml
# Pourquoi d'abord le pom.xml seul ? Parce que Docker met en cache
# chaque étape. Si le code change mais pas le pom.xml, Docker
# ne retélécharge pas les dépendances Maven — gain de temps énorme
COPY pom.xml .

# On télécharge toutes les dépendances Maven
RUN mvn dependency:go-offline -B

# Maintenant on copie tout le code source
COPY src ./src

# On compile et package le projet en JAR
# -DskipTests : on ne relance pas les tests pendant le build Docker
RUN mvn package -DskipTests

# ===================== ÉTAPE 2 : RUN =====================
# Image finale légère — juste Java 17, sans Maven
# On repart d'une image propre pour ne pas embarquer Maven
# et tous les fichiers de compilation dans l'image finale
FROM eclipse-temurin:17-jre-alpine

# Dossier de travail dans le conteneur final
WORKDIR /app

# On copie uniquement le JAR produit par l'étape BUILD
# Le JAR est dans target/ et se nomme ms-utilisateurs-0.0.1-SNAPSHOT.jar
COPY --from=build /app/target/ms-utilisateurs-0.0.1-SNAPSHOT.jar app.jar

# On expose le port 8081 — documentation pour Docker
# (ne suffit pas seul, il faut aussi le mapper dans docker-compose)
EXPOSE 8081

# Commande exécutée au démarrage du conteneur
ENTRYPOINT ["java", "-jar", "app.jar"]