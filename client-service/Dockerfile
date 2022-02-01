FROM maven:3.6.3 AS maven
LABEL MAINTAINER="htyesilyurt@gmail.com"

WORKDIR /opt/client-service
COPY . /opt/client-service
RUN mvn clean install 

# For Java 11, 
FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=client-service.jar

WORKDIR /opt/client-service

COPY --from=maven /opt/client-service/target/${JAR_FILE} /opt/client-service/

ENTRYPOINT ["java","-jar","client-service.jar"]