# Etapa 1: Build (usando JDK 17)
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa 2: Runtime (usando JDK 17)
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Define a porta (Render define a variavel PORT automaticamente)
EXPOSE 8080

# Comando de execucao
ENTRYPOINT ["java", "-jar", "app.jar"]