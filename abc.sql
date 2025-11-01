create database hospital_management_system;
use hospital_management_system;

CREATE TABLE login (
    ID VARCHAR(20) PRIMARY KEY,
    PW VARCHAR(20) NOT NULL
);

select * from login;                     

create table patient_info(ID varchar(20), Number varchar(40), Name varchar(20), Gender varchar(20), Patient_disease varchar(20), Room_Number varchar(20), Time varchar(100), Deposite varchar(20) );
select * from patient_info;

create table Room(room_no varchar(20), Availability varchar(20), Price varchar(20), Room_Type varchar(100));
select * from room;

insert into Room values("100","Available","500","G Bed 1");
insert into Room values("101","Availabile","500","G Bed 2");
insert into Room values("102","Availabile","500","G Bed 3");
insert into Room values("103","Availabile","500","G Bed 4");
insert into Room values("200","Availabile","1500","Private Room");
insert into Room values("201","Availabile","1500","Private Room");
insert into Room values("202","Availabile","1500","Private Room");
insert into Room values("203","Availabile","1500","Private Room");
insert into Room values("300","Availabile","3500","ICU Bed 1");
insert into Room values("301","Availabile","3500","ICU Bed 2");
insert into Room values("302","Availabile","3500","ICU Bed 3");
insert into Room values("303","Availabile","3500","ICU Bed 4");
insert into Room values("304","Availabile","3500","ICU Bed 5");
insert into Room values("305","Availabile","3500","ICU Bed 6");

create table department(Department varchar(100), Phone_no varchar(20));
select * from department;

insert into department values("Surgical department", "123456789");
insert into department values("Nursing department", "123456789");
insert into department values("Operation theater complex (OT)", "123456789");
insert into department values("Paramedical department", "123456789");

create table EMP_INFO(Name varchar(20), Age varchar(20), Phone_Number varchar(20), salary varchar(20), Gmail varchar(20), Aadhar_Number varchar(20));
select * from EMP_INFO;

insert into EMP_INFO values("Dpctors1","30","123456789", "50000", "dr@gmail.com", "123456789101");
insert into EMP_INFO values("Dpctors2","30","123456789", "50000", "dr@gmail.com", "123456789101");

create table Ambulance(Name varchar(20),Gender varchar(20), Car_name varchar(20), Available varchar(20), Location varchar(20));
insert into Ambulance values("av", "Male", "ZEN", "Available", "area 16"); 
select * from Ambulance;


