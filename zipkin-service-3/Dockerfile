FROM openjdk:8-jdk-alpine
MAINTAINER Ramazan Sakin <ramazansakin63@gmail.com>
ADD target/*.jar zipkin-service-3.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/zipkin-service-3.jar"]