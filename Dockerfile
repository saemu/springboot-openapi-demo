# syntax=docker/dockerfile:1
FROM docker.io/library/maven:3.8.4-openjdk-11 as BUILDER
WORKDIR /src
COPY . .
RUN mvn clean verify

FROM docker.io/library/openjdk:8-jdk-alpine
COPY --from=BUILDER /src/app/target/app-*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]