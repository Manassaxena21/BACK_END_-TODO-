FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_URI=mongodb://localhost:27017/task_db
EXPOSE 8081
ADD ./target/userTaskService-0.0.1-SNAPSHOT.jar /usr/src/userTaskService-0.0.1-SNAPSHOT
ENTRYPOINT ["java","-jar","userTaskService-0.0.1-SNAPSHOT"]
