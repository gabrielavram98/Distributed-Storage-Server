FROM openjdk:17
WORKDIR /app
COPY ./src/main/java/proiectdiz/Storage/StorageApplication.java /app
COPY pom.xml .
COPY . .
RUN ./mvnw package -DskipTests
CMD ["java", "-jar", "./out/artifacts/Storage_jar/Storage.jar"]




