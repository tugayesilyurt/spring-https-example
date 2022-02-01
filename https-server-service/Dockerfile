FROM maven:3.6.3 AS maven
LABEL MAINTAINER="htyesilyurt@gmail.com"

WORKDIR /opt/https-server-service
COPY . /opt/https-server-service
RUN mvn clean install 

# For Java 11, 
FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=https-server-service.jar

WORKDIR /opt/https-server-service

COPY --from=maven /opt/https-server-service/target/${JAR_FILE} /opt/https-server-service/

ENTRYPOINT ["java","-jar","https-server-service.jar"]