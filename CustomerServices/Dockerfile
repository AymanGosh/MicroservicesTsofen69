FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE='target/*.jar'
COPY ${JAR_FILE} CustomerMS-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/CustomerMS-0.0.1-SNAPSHOT.jar"]