# Use a imagem oficial do OpenJDK como base
FROM openjdk:17-jdk-alpine

# Cria e define o diretório de trabalho
WORKDIR /app

# Copia os arquivos de configuração do Maven
COPY mvnw .
COPY pom.xml .

# Concede permissão de execução para o script mvnw
RUN chmod +x mvnw

# Baixa as dependências
RUN ./mvnw dependency:go-offline

# Copia o código-fonte do projeto
COPY src ./src

# Compila o aplicativo
RUN ./mvnw package

# Define o comando de inicialização
CMD ["java", "-jar", "target/fwave-0.0.1-SNAPSHOT.war"]

