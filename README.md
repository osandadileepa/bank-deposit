# Getting Started

Test project to add Bank account and account holder information.

# Build and Deployement instruction

## Development Enviroment setup

Make sure following are met

- JDK 1.8
- Docker and Docker Compose
- MySQL 5.7.xx


## Mysql User credentials

- Following username and password should include
  username: root,
  password: root
- Mysql instance should be exposed in localhost in port 3306
- jdbc:mysql://localhost:3306/

## Appication source and development envioronment

- Backend available at src/main/java
- MySQL instance will be available by using docker-compose file at src/main/docker(command : docker-compose up)
- Backend will be available by using following command at the project root.
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

## Build application binary

In the project root directory execute the following bach script

```bash
./build.sh
```

## Start the application

- MySQL instance should available at locally, port 3306 with root username and root password in order to jar file to work.

```bash
java -jar -Dspring.profiles.active=dev target/student-grade-0.0.1-SNAPSHOT.jar
```

After executing above command application api is presented at http://localhost:8080/api


## To excute docker based containerized deployement

- Run the docker-compose.yml file using the following command

```bash
docker-compose up --build
```

- After few munutes application with the api is available at http://localhost:8080/api