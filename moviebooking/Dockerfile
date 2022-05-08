FROM openjdk:8-jdk-alpine
MAINTAINER moviebookingsystem.com
RUN apt-get update \
    && apt-get install -y git

RUN cd moviebookingsystem \
    && chmod +x mvnw \
    && ./mvnw -DskipTests=true package

ADD ./target/moviebookingsystem-0.0.1-SNAPSHOT.jar /root/
CMD ["java", "-jar", "/root/moviebookingsystem-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080