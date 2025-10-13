# Etapa 1: Build (compila o projeto)
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa 2: Runtime (roda apenas o .jar gerado)
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Define a porta (Render define a variavel PORT automaticamente)
EXPOSE 8080

# Comando de execucao
ENTRYPOINT ["java", "-jar", "app.jar"]
