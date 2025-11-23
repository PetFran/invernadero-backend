# ========== Etapa de build ==========
FROM maven:3.9-eclipse-temurin-21-alpine AS build

# Carpeta de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el pom y el código fuente
COPY pom.xml .
COPY src ./src

# Compilamos el proyecto (sin tests para que sea más rápido)
RUN mvn -q -B clean package -DskipTests

# ========== Etapa de ejecución ==========
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# ⛔ IMPORTANTE: cambia backend-0.0.1-SNAPSHOT.jar por el nombre real de tu jar
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar

# Render usará la variable PORT, pero exponemos 8080 por defecto
ENV PORT=8080
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
