FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} DockerCompose-v-1.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/DockerCompose-v-1.jar"]
