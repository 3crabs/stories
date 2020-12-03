FROM gradle:6.7.0-jdk11 as builder
WORKDIR /java
COPY . .
RUN gradle shadowJar

FROM openjdk:14-alpine
COPY --from=builder /java/build/libs/stories-*-all.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]