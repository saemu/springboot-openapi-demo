# syntax=docker/dockerfile:1
FROM openjdk:8-jdk-alpine
COPY app/target/app-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]