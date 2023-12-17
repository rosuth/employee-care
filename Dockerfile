FROM openjdk:8-jdk-alpine
EXPOSE 8080
WORKDIR /app
COPY target/employee-care.jar /app/employee-care.jar
ENTRYPOINT ["java","-jar","employee-care.jar"]
