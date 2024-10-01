# Establecer la imagen base de Maven para la compilación
FROM maven:3.8.6-openjdk-17 AS build

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el archivo POM y las dependencias
COPY pom.xml .

# Descarga las dependencias sin compilar
RUN mvn dependency:go-offline

# Copiar el código fuente y compilar la aplicación
COPY src ./src
RUN mvn package -DskipTests

# Usar la imagen de JDK para ejecutar la aplicación
FROM openjdk:17-jdk-slim

# Establecer directorio de trabajo
WORKDIR /app

# Copiar el JAR desde la etapa de compilación
COPY --from=build /app/target/filmsrepository-0.0.1-SNAPSHOT.jar /app/filmsrepository.jar

# Exponer el puerto
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "filmsrepository.jar"]
