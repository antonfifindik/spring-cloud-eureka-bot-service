FROM java:8-jdk-alpine

COPY ./target/bot-service-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch bot-service-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","bot-service-0.0.1-SNAPSHOT.jar"]