FROM openjdk:8-jdk-alpine
LABEL dev="rohit"
EXPOSE 8080
WORKDIR /app
COPY target/employeecare.war /app/employeecare.war
ENTRYPOINT ["java","-jar","employeecare.war"]
