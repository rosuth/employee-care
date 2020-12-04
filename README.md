## Employee Care

A project that deals with managing employees in a workspace by eliminating some of the manual tasks and making things more easier than
before, it's a web application built using Spring framework of Java along with other technologies.

This project has a seperate dashboard for the employees and admins of an organization, both have different sets of access that makes them
apart. An admin has full control over the employees while an employee has access to their own profile and can apply for an leave or can
contact to system admins.

## Admin

1. Has the full access to the system and can view the profiles of employees.
2. Can create/edit/delete an employee
3. Can send email to the employees
4. Can respond to the leave requests via email
5. Can fetch the employee data

## Employee

1. Can see their profile
2. Can apply for a leave
3. Can contact system admins
4. Can change their profile

## RESTful APIs

GET: http://localhost:8080/app/apis/admin
GET: http://localhost:8080/app/apis/admin/1
POST: http://localhost:8080/app/apis/admin
PUT: http://localhost:8080/app/apis/admin/1
DELETE: http://localhost:8080/app/apis/admin
DELETE: http://localhost:8080/app/apis/admin/1

GET: http://localhost:8080/app/apis/employee
GET: http://localhost:8080/app/apis/employee/1
POST: http://localhost:8080/app/apis/employee
PUT: http://localhost:8080/app/apis/employee/1
DELETE: http://localhost:8080/app/apis/employee
DELETE: http://localhost:8080/app/apis/employee/1

GET: http://localhost:8080/app/apis/employeeleave
GET: http://localhost:8080/app/apis/employeeleave/1
POST: http://localhost:8080/app/apis/employeeleave
PUT: http://localhost:8080/app/apis/employeeleave/1
DELETE: http://localhost:8080/app/apis/employeeleave
DELETE: http://localhost:8080/app/apis/employeeleave/1

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

1. git clone https://www.github.com/rohiton/employeecare
2. cd employeecare
3. Go to src/main/resources and change the database configuration for localhost and set username and password for email
4. Find db.sql under sql folder and run the entire script
5. mvn eclipse:eclipse && mvn clean install
6. mvn spring-boot:run

Note: You've to enable the less secure option in your Google account

Project will be up at localhost:8080/app

## Docker 

To deploy this project on Docker

1. Change the database configuration first in application.properties
2. locate docker-compose.yml and hit docker-compose up -d
3. Go into the shell of your mysql container and hit the sql script
4. Restart using docker-compose restart

Project will be up at localhost:8080/app

## Kubernetes

To deploy this project using Kubernetes (Minikube)

1. git clone https://www.github.com/rohiton/employeecare
2. Change the database configuration first in application.properties
3. docker pull mysql:5.7
4. docker pull 100598/employeecare:1.0 or build on your own with docker build -t 100598/employeecare:1.0 . command
5. cd deployments
6. Apply all the yml's file one by one
7. Run the sql script in mysql pod
8. Add the 192.168.###.## employeecare.com in your /etc/hosts file
9. Hit employeecare.com:{PORT}/app in browser

This project is contributed by Rohit Suthar
rohitkumar1121.rk@gmail.com
