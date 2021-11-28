## Employee Care

A project that deals with managing employees in a workspace by eliminating some of the manual tasks and making things more easier than
before, it's a web application built using Spring framework of Java along with other technologies.

This project has a seperate dashboard for the employees and admins of an organization, both have different sets of access that makes them
apart. An admin has full control over the employees while an employee has access to their own profile and can apply for an leave or can
contact to system admins.

## Admin

1. Has the full access to the system and can view the profiles of employees
2. Can create/edit/delete an employee
3. Can send email to the employees individually
4. Can respond to the leave requests via email with ready to use templates
5. Can fetch the employee data with their id

## Employee

1. Can see their profile and update it
2. Can apply for multiple leave and will receive an email upon approval/disapproval of their leaves
3. Can contact system administrator

## REST APIs

- GET: http://localhost:8080/app/apis/admin
- GET: http://localhost:8080/app/apis/employee
- GET: http://localhost:8080/app/apis/employeeleave

You can make requests with GET, POST, PUT & DELETE. Find the respective API's in the code.

## Technologies Involved

1. Java
2. Spring/Spring Boot
3. MySQL
4. Maven
5. HTML/CSS/JS/Bootstrap
6. RESTful APIs
7. Docker
8. Kubernetes

## Run

To run this project on localhost using Maven

1. git clone https://www.github.com/rohiton98/employeecare
2. cd employeecare
3. Read DB instructions from /sql/mysql-db.md file
5. Run mvn eclipse:eclipse && mvn clean install
6. Run mvn spring-boot:run

Note: You've to enable the less secure option in your Google account

Project will be up at localhost:8080/app
Note: See the user credentials in the DB to login into any Admin or Employee account

Note: /app is the context path and if you change any request mapping or create a new one then change it accordingly, ignore the context path for hyperlinks in the view(JSP).

## Docker 

To deploy this project with Docker:

1. Change the database configuration first in application.properties
2. locate docker-compose.yml and change the database user credentials identical to applicatio.properties and hit docker-compose up -d on project root directory
3. Go into the shell of your mysql container and run the sql script available under sql folder
4. Restart both the containers using docker-compose restart to reflect your changes

To get into container shell of mysql: docker exec -it {mysql-container-name} bash

Project will be up at localhost:8080/app

## Kubernetes

To deploy this project on Minikube(single node cluster) with Kubernetes:

1. git clone https://www.github.com/rohiton98/employeecare
2. Change the database configuration first in application.properties
3. docker pull mysql:5.7
4. docker pull 100598/employeecare:1.0 or build on your own with docker build -t 100598/employeecare:1.0 .
5. cd deployments
6. Apply all the yml's file one by one
7. Run the sql script in mysql pod
8. Add the 192.168.###.## employeecare.com in your /etc/hosts file
9. Hit employeecare.com:{PORT}/app in browser

