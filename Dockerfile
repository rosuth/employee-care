FROM openjdk:8-jdk-alpine
COPY target/employeecare.jar employeecare.jar
ENTRYPOINT ["java","-jar","/employeecare.jar"]
