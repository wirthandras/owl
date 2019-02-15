FROM openjdk:8-jdk-alpine

LABEL maintanier="agrippa.wia@gmail.com"

VOLUME /tmp

EXPOSE 9000

ARG JAR_FILE=target/Owl-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} Owl.jar

ENTRYPOINT ["java", "-jar","-Dowl.target.server.url=${OWL_URL}","/Owl.jar"]
