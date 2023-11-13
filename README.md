# Project Title

Proyecto Spring Boot para evaluar conocimientos 

## Requisitos
Para construir y ejecutar la aplicación necesitas:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)
- [Docker](https://www.docker.com/)

## Construir el proyecto
Para contuir este proyecto simplemente se debe ejecutar el siquiente comando
- mvn clean package

## Levantar el proyecto localmente

Para levantar el proyecto de forma local, se debe ejecutar el siguiente comando

- mvn spring-boot:run

## Documentacion del API

Despues de iniciar la aplicacion, puedes ver la documentación del API de Swagger en 'http://localhost:8080/swagger-ui.html'.

## Dockerización

Para construir la imagen Docker de esta aplicacion utiliza el siguiente comando en el directorio raiz del proyecto

- docker build -t productapplication .

Para iniciar la aplicacion con Docker, usa el siguiente comando

- docker run -p 8080:8080 productapplication

Este comando iniciará un contenedor Docker y la aplicacion sera accesible en 'http://localhost:8080'.