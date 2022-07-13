FROM openjdk:17-alpine

MAINTAINER Ramazan Sakin <ramazansakin63@gmail.com>
EXPOSE 8081
ADD target/passenger-analyzer-0.0.1-SNAPSHOT.jar passenger-analyzer.jar

ENTRYPOINT ["java","-jar","passenger-analyzer.jar"]