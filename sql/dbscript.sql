CREATE DATABASE employee_care;
use employee_care;

CREATE TABLE role (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE admin (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255)
);

CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(255),
    firstname VARCHAR(255),
    lastname VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    dob VARCHAR(10),
    gender VARCHAR(10),
    address VARCHAR(255),
    city VARCHAR(255)
);

CREATE TABLE employee_leave (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    emp_id BIGINT,
    email VARCHAR(255),
    leave_type VARCHAR(255),
    fullname VARCHAR(255),
    leave_start VARCHAR(10),
    leave_end VARCHAR(10),
    days VARCHAR(255),
    reason VARCHAR(255),
    FOREIGN KEY (emp_id) REFERENCES employee(id)
);

CREATE TABLE admin_role (
    admin_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (admin_id, role_id),
    FOREIGN KEY (admin_id) REFERENCES admin(id),
    FOREIGN KEY (role_id) REFERENCES role(ID)
);

CREATE TABLE employee_role (
    emp_id BIGINT,
    role_id BIGINT,
    PRIMARY KEY (emp_id, role_id),
    FOREIGN KEY (emp_id) REFERENCES employee(id),
    FOREIGN KEY (role_id) REFERENCES role(ID)
);

INSERT INTO role (name) VALUES ('ROLE_ADMIN');

INSERT INTO admin (firstname, lastname, email, password) VALUES ('Admin1', 'LastName1', 'admin1@example.com', 'adminpassword');

INSERT INTO admin_role (admin_id, role_id) VALUES (1, 1);