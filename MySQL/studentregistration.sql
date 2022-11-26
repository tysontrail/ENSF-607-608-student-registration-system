DROP DATABASE IF EXISTS STUDENTREGISTRATION;
CREATE DATABASE STUDENTREGISTRATION; 
USE STUDENTREGISTRATION;

DROP TABLE IF EXISTS STUDENT;
CREATE TABLE STUDENT (
	StudentID				integer not null,
	LName				varchar(25) not null,
	FName				varchar(25) not null,
	primary key (StudentID)
);

INSERT INTO STUDENT (StudentID, LName, FName)
VALUES
(1,'Trail','Tyson'),
(2,'Weech','Kennethy'),
(3,'Burr','Bill'),
(4,'Holmes','Hollis');


DROP TABLE IF EXISTS DEPARTMENT;
CREATE TABLE DEPARTMENT (
	DepID			integer not null,
    DepCode			varchar(50) not null,
	DepName				varchar(50) not null,
	primary key (DepID)
);

INSERT INTO DEPARTMENT (DepID, DepCode, DepName)
VALUES
(1,'ENSF', 'Software Engineering'),
(2,'ENME', 'Mechanical Engineering'),
(3,'MATH', 'Mathematics');


DROP TABLE IF EXISTS COURSE;
CREATE TABLE COURSE (
	CourseID			integer not null,
	CNumber				integer not null,
	CName				varchar(50) not null,
    Department_fk		integer not null,
	primary key (CourseID),
    foreign key (Department_fk) references DEPARTMENT(DepID)
);

INSERT INTO COURSE (CourseID, CNumber, CName, Department_fk)
VALUES
(1, '607','Architecture', 1),
(2, '608','Databases', 1),
(3, '611','How Baby Learn', 2),
(4, '612','Big Data', 2),
(5, '614','System Design', 3);



DROP TABLE IF EXISTS OFFERING;
CREATE TABLE OFFERING (
	Section				varchar(3) not null,
	CourseID			integer not null,
	primary key (Section,CourseID),
	foreign key (CourseID) references COURSE(CourseID),
    unique(Section, CourseID)
);

INSERT INTO OFFERING (Section, CourseID)
VALUES
('01', 1),
('02',1),
('01',2),
('02',2),
('01',3),
('02',3);

DROP TABLE IF EXISTS REGISTRATION;
CREATE TABLE REGISTRATION (
	Student			    integer not null,
	Section				varchar(3) not null,
	CourseID			integer,
	Grade				varchar(1) not null,
	primary key (Student,Section,CourseID),
	foreign key (Student) references STUDENT(StudentID),
	foreign key (Section, CourseID) references OFFERING(Section, CourseID)
);

INSERT INTO REGISTRATION (Student, Section, CourseID, Grade)
VALUES
(1, '01', 1, 'A'),
(2, '01', 1, 'B'),
(3, '02', 1, 'C'),
(4, '02', 1, 'D');


DROP TABLE IF EXISTS PREREQUISITE;
CREATE TABLE PREREQUISITE (
	CID	 	integer not null,
    PID 	integer not null,
	primary key (CID, PID),
	foreign key (CID) references COURSE(CourseID),
	foreign key (PID) references COURSE(CourseID)
    );

INSERT INTO PREREQUISITE (CID, PID)
VALUES
(1, 2), 
(2, 3), 
(3, 4);
