# ===================== ÉTAPE 1 : BUILD =====================
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY src ./src

RUN mvn package -DskipTests

# ===================== ÉTAPE 2 : RUN =====================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Seule différence avec ms-utilisateurs : le nom du JAR
COPY --from=build /app/target/ms-formations-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]