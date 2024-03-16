FROM openjdk:17-jdk-alpine
COPY ./target/CompanyService-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch CompanyService-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","CompanyService-0.0.1-SNAPSHOT.jar"]
