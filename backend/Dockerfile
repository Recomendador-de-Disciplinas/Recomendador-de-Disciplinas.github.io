FROM gradle:7.2.0-jdk11 AS build

WORKDIR /usr/src/app

COPY . .

RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk11:jre11u-alpine-nightly

COPY --from=build /usr/src/app/build/libs/backend-0.0.1-SNAPSHOT.jar app.jar

USER root

CMD ["java", "-jar", "app.jar"]