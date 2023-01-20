drop schema if exists emdbmisTest;

CREATE DATABASE IF NOT EXISTS emdbmisTest;
use emdbmisTest;

CREATE TABLE TblEmployee_PersonalInfo(
emp_id int NOT NULL AUTO_INCREMENT,
lname varchar (50) NOT NULL,
fname varchar(50) NOT NULL,
mname varchar(50) NOT NULL,
name_ext varchar(50) NOT NULL,
gender varchar(50) NOT NULL,
height varchar(50) NOT NULL,
weight varchar(50) NOT NULL,
blood_type varchar(50) NOT NULL,
cstatus varchar(50) NOT NULL,
bdate datetime NOT NULL,
pdate varchar(50) NOT NULL,
age int NOT NULL, 
religion varchar(50) NOT NULL,
citizenship varchar (50) NOT NULL,
res_add varchar(50) NOT NULL,
perm_add varchar(50) NOT NULL,
email_add varchar(50) NOT NULL,
tel_no varchar(50) NOT NULL,
mobile_no varchar(50) NOT NULL,
gsisID_no varchar(50) NOT NULL,
pagIbigID_no varchar(50) NOT NULL,
philhealthID_no varchar(50) NOT NULL,
sss_no varchar(50) NOT NULL,
tin_no varchar(50) NOT NULL,

PRIMARY KEY (emp_id)
);

CREATE TABLE TblEducation_Info(
educ_id  int NOT NULL AUTO_INCREMENT,
emp_id int NOT NULL,
elem_name varchar(50) NOT NULL,
elem_add varchar(50) NOT NULL,
elem_year varchar(50) NOT NULL,
sec_name varchar(50) NOT NULL,
sec_add varchar(50) NOT NULL,
sec_year varchar(50) NOT NULL,
ter_name varchar(50) NOT NULL,
ter_add varchar(50) NOT NULL,
ter_course varchar(50) NOT NULL,
ter_year varchar(50) NOT NULL,
PRIMARY KEY (educ_id),
FOREIGN KEY (emp_id) REFERENCES TblEmployee_PersonalInfo(emp_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE TblSpouse_Info(
spouse_id  int NOT NULL AUTO_INCREMENT,
emp_id int NOT NULL,
spouse_lname varchar(50) NOT NULL,
spouse_fname varchar(50) NOT NULL,
spouse_mname varchar(50) NOT NULL,
spouse_extname varchar(50) NOT NULL,
spouse_occu varchar(50) NOT NULL,
spouse_tel varchar(50) NOT NULL,
PRIMARY KEY (spouse_id),
FOREIGN KEY (emp_id) REFERENCES TblEmployee_PersonalInfo(emp_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE TblChildren_Info ( 
child_id  int NOT NULL AUTO_INCREMENT,
emp_id int NOT NULL,
child_lname varchar(50) NOT NULL,
child_fname varchar(50) NOT NULL,
child_mname varchar(50) NOT NULL,
child_extname varchar(50) NOT NULL,
bdate datetime NOT NULL,
PRIMARY KEY (child_id),
FOREIGN KEY (emp_id) REFERENCES TblEmployee_PersonalInfo(emp_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE TblParents_Info (
parents_id  int NOT NULL AUTO_INCREMENT,
emp_id int NOT NULL,
father_lname varchar(50) NOT NULL,
father_fname varchar(50) NOT NULL,
father_mname varchar(50) NOT NULL,
father_extname varchar(50) NOT NULL,
mother_lname varchar(50) NOT NULL,
mother_fname varchar(50) NOT NULL,
mother_mname varchar(50) NOT NULL,
PRIMARY KEY (parents_id),
FOREIGN KEY (emp_id) REFERENCES TblEmployee_PersonalInfo(emp_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE TblFamily_Info (
fam_id  int NOT NULL AUTO_INCREMENT,
emp_id int NOT NULL,
spouse_id int NOT NULL,
parents_id int NOT NULL,
child_id int NOT NULL,
PRIMARY KEY (fam_id),
FOREIGN KEY (emp_id) REFERENCES TblEmployee_PersonalInfo(emp_id) ON UPDATE CASCADE ON DELETE CASCADE, 
FOREIGN KEY (spouse_id) REFERENCES TblSpouse_Info (spouse_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (child_id) REFERENCES TblChildren_Info(child_id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (parents_id) REFERENCES TblParents_Info(parents_id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE TblUsers  (
  user_id int NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  contact_number varchar(50) NOT NULL,
  job_dept varchar(50) NOT NULL,
  position varchar(50) NOT NULL,
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  user_type int NOT NULL,
  PRIMARY KEY (user_id)
);
 
CREATE TABLE TblEmployee_Occupation (
emoccu_id int NOT NULL AUTO_INCREMENT,
emp_id int NOT NULL,
dept_title varchar(50) NOT NULL,
emp_post varchar(50) NOT NULL,
emp_status varchar(50) NOT NULL,
starting_date datetime NOT NULL,
leaving_date datetime NOT NULL,
salary_title varchar (50) NOT NULL,
mon_rate int NOT NULL,
PRIMARY KEY (emoccu_id),
FOREIGN KEY (emp_id) REFERENCES TblEmployee_PersonalInfo (emp_id) ON UPDATE CASCADE ON DELETE CASCADE
);