FROM openjdk:11-jre-slim

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

#VOLUME /logs

#COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","app.jar"]