CREATE DATABASE hospital_management_system;
USE hospital_management_system;

-- LOGIN table
CREATE TABLE login (
    USERNAME VARCHAR(50) PRIMARY KEY,
    PASSWORD VARCHAR(50)
);
INSERT INTO login (USERNAME, PASSWORD) VALUES ('admin', 'admin123');

-- patient_info table
CREATE TABLE patient_info (
    ID VARCHAR(20),
    NUMBER VARCHAR(40),
    NAME VARCHAR(20),
    GENDER VARCHAR(20),
    PATIENT_DISEASE VARCHAR(50),
    ROOM_NUMBER VARCHAR(20),
    TIME VARCHAR(100),
    DEPOSITE VARCHAR(50)
);

-- room table
CREATE TABLE room (
    ROOM_NO VARCHAR(20),
    AVAILABILITY VARCHAR(20),
    PRICE VARCHAR(20),
    ROOM_TYPE VARCHAR(100)
);

INSERT INTO room (ROOM_NO, AVAILABILITY, PRICE, ROOM_TYPE) VALUES
('101', 'Available', '1500', 'Single AC'),
('102', 'Occupied', '1200', 'Single Non-AC'),
('103', 'Available', '2000', 'Double AC'),
('104', 'Available', '1800', 'Double Non-AC'),
('105', 'Occupied', '2500', 'ICU'),
('106', 'Available', '3000', 'Deluxe'),
('107', 'Occupied', '3500', 'Private Suite');

-- department table
CREATE TABLE department (
    DEPARTMENT VARCHAR(100),
    PHONE_NO VARCHAR(20)
);

INSERT INTO department (DEPARTMENT, PHONE_NO) VALUES
('Cardiology', '033-4001-1100'),
('Neurology', '033-4001-1101'),
('Orthopedics', '033-4001-1102'),
('Pediatrics', '033-4001-1103'),
('Oncology', '033-4001-1104'),
('Radiology', '033-4001-1105'),
('Emergency', '033-4001-1106'),
('Gynecology', '033-4001-1107');

-- emp_info table
CREATE TABLE emp_info (
    NAME VARCHAR(20),
    AGE VARCHAR(20),
    PHONE_NUMBER VARCHAR(20),
    SALARY VARCHAR(20),
    GMAIL VARCHAR(50),
    AADHAR_NUMBER VARCHAR(20)
);

INSERT INTO emp_info VALUES ("Doctors1", "30", "1234567890", "50000", "dr1@gmail.com", "123456789101");
INSERT INTO emp_info VALUES ("Doctors2", "32", "9876543210", "55000", "dr2@gmail.com", "123456789102");
INSERT INTO emp_info VALUES ("Nurse1",   "28", "9998887776", "30000", "n1@gmail.com",  "123456789103");
INSERT INTO emp_info VALUES ("Admin1",   "35", "9998887775", "40000", "admin@gmail.com", "123456789104");

-- ambulance table
CREATE TABLE ambulance (
    NAME VARCHAR(20),
    GENDER VARCHAR(20),
    CAR_NAME VARCHAR(20),
    AVAILABLE VARCHAR(20),
    LOCATION VARCHAR(50)
);

INSERT INTO ambulance VALUES ("av", "Male", "ZEN", "Available", "Area 16");
INSERT INTO ambulance VALUES ("Suman", "Male", "Innova", "Unavailable", "Sector 5");
INSERT INTO ambulance VALUES ("Puja", "Female", "AmbuX", "Available", "Salt Lake");
INSERT INTO ambulance VALUES ("Ravi", "Male", "Omni", "Available", "Area 7");

-- View login data
SELECT * FROM login;

-- View patient_info data
SELECT * FROM patient_info;

-- View room data
SELECT * FROM room;

-- View department data
SELECT * FROM department;

-- View emp_info data
SELECT * FROM emp_info;

-- View data
SELECT * FROM ambulance;