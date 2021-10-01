FROM openjdk:11-jre-slim
WORKDIR usr/src
EXPOSE 8086
ADD ./target/user-authentication-service.jar /usr/src/user-authentication-service.jar
ENTRYPOINT ["java","-jar","user-authentication-service.jar"]