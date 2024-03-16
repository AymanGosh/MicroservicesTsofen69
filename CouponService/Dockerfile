FROM openjdk:17-jdk-alpine

VOLUME /tmp

ARG JAR_FILE='target/*.jar'

COPY ${JAR_FILE} CouponService.jar

ENTRYPOINT ["java","-jar","/CouponService.jar"]