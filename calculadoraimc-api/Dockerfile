# --- BUILD ----
FROM maven:3-openjdk-17-slim as build

WORKDIR /app

COPY pom.xml .
COPY src src



ENV MAVEN_OPTS="-Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn"

RUN cat pom.xml
RUN --mount=type=cache,target=/root/.m2,rw mvn package -Dmaven.test.skip=true

# --- RUN ----

FROM openjdk:17-slim

RUN apt update && \
    apt upgrade -y && \
    apt install libfreetype6 fontconfig -y

WORKDIR /app
COPY --from=build /app/target/calculadoraimc-api-0.0.1-SNAPSHOT.jar /app/app.jar

ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/calculadoraimc?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]