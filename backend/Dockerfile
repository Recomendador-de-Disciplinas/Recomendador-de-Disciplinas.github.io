FROM adoptopenjdk/openjdk11:alpine

ENV PORT=8080

WORKDIR /usr/src/app

COPY . .

RUN ./gradlew jar

EXPOSE ${PORT}

CMD ./gradlew bootRun