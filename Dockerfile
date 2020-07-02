FROM openjdk:8-jdk-alpine as builder
RUN mkdir -p /app/source
COPY . /app/source
WORKDIR /app/source
RUN ./mvnw clean install -DskipTests

FROM builder
COPY --from=builder /app/source/target/*.jar bank-deposit-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=prod", "bank-deposit-0.0.1-SNAPSHOT.jar"]



