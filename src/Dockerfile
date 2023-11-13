# Usa una imagen base de OpenJDK para Java 17
FROM adoptopenjdk/openjdk17:alpine-jre

# Establece el directorio de trabajo en la aplicación
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
COPY target/challenge-robert-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 (o el puerto que estés usando en tu aplicación Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]