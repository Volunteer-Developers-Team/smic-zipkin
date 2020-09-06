FROM openjdk:8-jdk-alpine
MAINTAINER Ramazan Sakin <ramazansakin63@gmail.com>
ADD target/*.jar zipkin-service-2.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/zipkin-service-2.jar"]