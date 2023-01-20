DELIMITER $$
CREATE PROCEDURE insertEmployeeInfo (
	lname0 varchar(50),
    fname0 varchar(50),
    mname0 varchar(50),
    name_ext0 varchar(50),
    gender0 varchar(50),
    height0 varchar(50),
    weight0 varchar(50),
    blood_type0 varchar(50),
    cstatus0 varchar(50),
    bdate0 datetime,
    pdate0 varchar(50),
    age0 int,
    religion0 varchar(50),
    citizenship0 varchar(50),
    res_add0 varchar(50),
    perm_add0 varchar(50),
    email_add0 varchar(50),
    tel_no0 varchar(50),
    mobile_no0 varchar(50),
    gsisID0 varchar(50),
    pagibigID_no0 varchar(50),
    philhealthID_no0 varchar(50),
    sss_no0 varchar(50),
    tin_no0 varchar(50)
)
BEGIN
	INSERT INTO `TblEmployee_PersonalInfo`
	(`lname`,`fname`, `mname`, `name_ext`, `gender`, `height`, `weight`, `blood_type`, `cstatus`, `bdate`, `pdate`,
	`age`, `religion`, `citizenship`, `res_add`, `perm_add`, `email_add`, `tel_no`, `mobile_no`, `gsisID_no`, `pagIbigID_no`,
	`philhealthID_no`, `sss_no`, `tin_no`)
	VALUES
	(lname0,fname0, mname0, name_ext0, gender0, height0, weight0, blood_type0, cstatus0, bdate0, pdate0,
	age0, religion0, citizenship0, res_add0, perm_add0, email_add0, tel_no0, mobile_no0, gsisID0, pagIbigID_no0,
	philhealthID_no0, sss_no0, tin_no0);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `insertEmpEducInfo` 
(
	`emp_id0` int,
    `elem_name0` varchar(50),
    `elem_add0` varchar(50),
    `elem_year0` varchar(50),
    `sec_name0` varchar(50),
    `sec_add0` varchar(50),
    `sec_year0` varchar(50),
    `ter_name0` varchar(50),
    `ter_add0` varchar(50),
    `ter_course0` varchar(50),
    `ter_year0` varchar(50)
)
BEGIN
	INSERT INTO `TblEducation_Info`
	(`emp_id`, `elem_name`, `elem_add`, `elem_year`, `sec_name`,
	`sec_add`, `sec_year`, `ter_name`, `ter_add`, `ter_course`,`ter_year`)
	VALUES
	(emp_id0, elem_name0, elem_add0, elem_year0, sec_name0,
	sec_add0, sec_year0, ter_name0, ter_add0, ter_course0, ter_year0);
END $$
DELIMITER 

DELIMITER $$
CREATE PROCEDURE insertEmpSpouseInfo (
	emp_id0 int,
    spouse_lname0 varchar(50),
    spouse_fname0 varchar(50),
    spouse_mname0 varchar(50),
    spouse_extname0 varchar(50),
    spouse_occu0 varchar(50),
    spouse_tel0 varchar(50)
)
BEGIN
	INSERT INTO `TblSpouse_Info`
	(`emp_id`, `spouse_lname`, `spouse_fname`, `spouse_mname`,
	`spouse_extname`, `spouse_occu`, `spouse_tel`)
	VALUES
	(`emp_id0`, `spouse_lname0`, `spouse_fname0`, `spouse_mname0`,
	`spouse_extname0`, `spouse_occu0`, `spouse_tel0`);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insertChildrenInfo (
	emp_id0 int, 
    child_lname0 varchar(50),
    child_fname0  varchar(50),
    child_mname0  varchar(50),
    child_extname0  varchar(50),
    bdate0 datetime
)
BEGIN
	INSERT INTO `TblChildren_Info`
	(`emp_id`, `child_lname`, `child_fname`, `child_mname`, `child_extname`, `bdate`)
	VALUES
	(`emp_id0`, `child_lname0`, `child_fname0`, `child_mname0`, `child_extname0`, `bdate0`);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insertParentInfo (
	emp_id0 int,
    father_lname0 varchar(50),
    father_fname0 varchar(50),
    father_mname0 varchar(50),
    father_extname0 varchar(50),
    mother_lname0 varchar(50),
    mother_fname0 varchar(50),
    mother_mname0 varchar(50)
)
BEGIN
	INSERT INTO `TblParents_Info`
	(`emp_id`, `father_lname`, `father_fname`, `father_mname`, `father_extname`, `mother_lname`, `mother_fname`,`mother_mname`)
	VALUES
	(`emp_id0`, `father_lname0`, `father_fname0`, `father_mname0`, `father_extname0`, `mother_lname0`, `mother_fname0`,`mother_mname0`);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insertFamilyInfo (
	emp_id0 int,
    spouse_id0 int,
    parents_id0 int,
    child_id0 int
)
BEGIN
	INSERT INTO `TblFamily_Info`
	(`emp_id`, `spouse_id`, `parents_id`, `child_id`)
	VALUES
	(`emp_id0`, `spouse_id0`, `parents_id0`, `child_id0`);
END $$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insertEmpOccupation (
	emp_id0 int,
    dept_title0 varchar(50),
    emp_post0 varchar(50),
    emp_status0  varchar(50),
    starting_date0 datetime,
    leaving_date0 datetime,
    salary_title0 varchar(50),
    mon_rate0 int
)
BEGIN
	INSERT INTO `TblEmployee_Occupation`
	(`emp_id`, `dept_title`, `emp_post`, `emp_status`,
	`starting_date`, `leaving_date`, `salary_title`, `mon_rate`)
	VALUES
	(`emp_id0`, `dept_title0`, `emp_post0`, `emp_status0`,
	`starting_date0`, `leaving_date0`, `salary_title0`, `mon_rate0`);

END $$
DELIMITER ;