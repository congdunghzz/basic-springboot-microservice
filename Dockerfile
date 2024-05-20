FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app


COPY pom.xml ./pom.xml

COPY userService/src ./userService/src
COPY userService/pom.xml /app/userService/pom.xml

WORKDIR /app/userService

RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jre-alpine

VOLUME /tmp

WORKDIR /app

COPY --from=build /app/userService/target/userService-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]