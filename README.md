## employee-care

Managing employees for a workplace

### Admin Privileges

1. Has the full access to the system and can view the profiles of employees
2. Can create/edit/delete an employee
3. Can send email to the employees individually
4. Can respond to the leave requests via email with ready to use templates
5. Can fetch the employee data with their id

### Employee Privileges

1. Can see their profile and update it
2. Can apply for multiple leaves and will receive an email upon approval/rejection of their leaves
3. Can contact system administrator within the app

### REST APIs Endpoints

- GET: http://localhost:8080/app/api/admin
- GET: http://localhost:8080/app/api/employee
- GET: http://localhost:8080/app/api/employeeleave

## Technologies Used

1. Java
2. Spring MVC
3. MySQL
4. Maven
5. HTML/CSS/JS/Bootstrap
6. RESTful APIs
7. Docker
8. Kubernetes

### How to run?

To run this project on localhost using Maven

1. git clone https://github.com/rosuth/employee-care
2. Build the project
3. Setup database and create tables
4. Run the project at localhost:8080/app

Note: You've to enable the less secure option in your Google account if you want to use email service

### Deploying using Docker 

To deploy this project with Docker:

1. Update database configuration first in application.properties
2. Locate docker-compose.yml and change the database user credentials identical to application.properties and hit docker-compose up -d on project root directory
3. Go into the shell of your mysql container and run the sql script available under sql folder
4. Restart both the containers using "docker-compose restart" to reflect your changes

To get into container shell of mysql: docker exec -it {mysql-container-name} bash

### Deploying in Kubernetes Cluster

To deploy this project on Minikube(single node cluster) with Kubernetes:

1. git clone https://github.com/rosuth/employee-care
2. Update the database configuration first in application.properties
3. docker pull mysql:5.7
4. docker pull {dockerhub-username}/employee-care:1.0 or build on your own with docker build -t {dockerhub-username}/employee-care:1.0 .
5. cd deployments
6. Apply all the yml's file one by one
7. Run the sql script in mysql pod
8. Add the 192.168.###.## employee-care.com in your /etc/hosts file
9. Hit employee-care.com:{PORT}/app in browser