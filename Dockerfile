FROM maven:latest

COPY . /canoe-polo-project


WORKDIR /canoe-polo-project


RUN mvn clean package

FROM java:8

WORKDIR /docker_myproject

COPY --from=0 /canoe-polo-project/target/CanoPoloApp-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
