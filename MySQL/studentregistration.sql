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
('123456','Trail','Tyson'),
('696969','Weech','Kennethy'),
('987654','Burr','Bill'),
('121212','Holmes','Hollis');

DROP TABLE IF EXISTS COURSE;
CREATE TABLE COURSE (
	CNumber				integer not null,
	CName				varchar(4) not null,
	primary key (CNumber,CName)
);

INSERT INTO COURSE (CNumber, CName)
VALUES
('607','ENSF'),
('608','ENSF'),
('611','ENSF'),
('612','ENSF'),
('614','ENSF');

DROP TABLE IF EXISTS OFFERING;
CREATE TABLE OFFERING (
	Section				varchar(3) not null,
	CNumber				integer not null,
	CName				varchar(4) not null,
	primary key (Section,CNumber,CName),
	foreign key (CNumber,CName) references COURSE(CNumber,CName)
);

INSERT INTO OFFERING (Section, CNumber, CName)
VALUES
('01','607','ENSF'),
('02','607','ENSF'),
('01','608','ENSF'),
('01','611','ENSF'),
('01','612','ENSF'),
('01','614','ENSF');

DROP TABLE IF EXISTS REGISTRATION;
CREATE TABLE REGISTRATION (
	Student			    integer not null,
	Section				varchar(3) not null,
	CNumber				integer not null,
	CName				varchar(4) not null,
	Grade				varchar(1) not null,
	primary key (Student,Section,CNumber,CName),
	foreign key (Student) references STUDENT(StudentID),
	foreign key (Section) references OFFERING(Section),
	foreign key (CNumber,CName) references COURSE(CNumber,CName)
);

-- INSERT INTO REGISTRATION (Student, Section, CNumber, CName, Grade)
-- VALUES
-- ;

DROP TABLE IF EXISTS PREREQUISITE;
CREATE TABLE PREREQUISITE (
	CNumber				integer not null,
	CName				varchar(4) not null,
	PNumber				integer not null,
	PName				varchar(4) not null,
	primary key (CNumber,CName,PNumber,PName),
	foreign key (CNumber,CName) references COURSE(CNumber,CName),
	foreign key (PNumber, PName) references COURSE(CNumber,CName)
    );

-- INSERT INTO PREREQUISITE (CNumber,CName,PNumber,PName)
-- VALUES