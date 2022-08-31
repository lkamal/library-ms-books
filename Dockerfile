# syntax=docker/dockerfile:1

FROM adoptopenjdk/openjdk13 as BUILD

WORKDIR /build

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src/ ./src

RUN ./mvnw clean package

FROM adoptopenjdk/openjdk13:alpine-jre

WORKDIR /app

COPY --from=BUILD /build/target/library-ms-books-1.0.0.jar /library-ms-books-1.0.0.jar

CMD ["java", "-jar", "/library-ms-books-1.0.0.jar"]
