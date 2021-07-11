
FROM openjdk:11 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:11
WORKDIR esh_agenda_backend-api
COPY --from=build target/*.jar esh_agenda_backend.jar
ENTRYPOINT ["java", "-jar", "esh_agenda_backend.jar"]