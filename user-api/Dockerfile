FROM openjdk:11-jre-slim
COPY build/libs/user-api-0.0.1-SNAPSHOT.jar user-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-DSpring.profiles.active=production", "-Dmailgun.key=${MAILGUN_KEY}","-jar", "user-api-0.0.1-SNAPSHOT.jar"]


#FROM ubuntu:latest
#LABEL authors="glass"

#ENTRYPOINT ["top", "-b"]