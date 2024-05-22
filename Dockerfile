# Usa a imagem oficial do OpenJDK 11 como base
FROM openjdk:21
# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Copia o Maven Wrapper (mvnw e mvnw.cmd) para o diretório de trabalho
COPY .mvn/wrapper/ .mvn/wrapper/
COPY mvnw .
COPY mvnw.cmd .

# Copia todo o código-fonte para o diretório de trabalho
COPY src ./src

# Permissão de execução para o Maven Wrapper
RUN chmod +x mvnw


# Executa o comando mvnw clean package para construir o pacote da aplicação
RUN ./mvnw clean package

# Expor a porta 8080 para comunicação interna do contêiner
EXPOSE 8080

# Comando para iniciar a aplicação Spring Boot quando o contêiner for iniciado
CMD ["java", "-jar", "target/clibank-1.0.0.jar", "--server.port=${PORT}"]
