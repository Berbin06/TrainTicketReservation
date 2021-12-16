
CREATE TABLE TRAINS (
  TRAIN_ID NUMBER GENERATED ALWAYS AS IDENTITY START WITH 2000 increment by 1,
 
  TRAIN_NAME varchar(50) NOT NULL,
  TRAIN_CLASS varchar(50) NOT NULL,
  TRAIN_NUMBER int NOT NULL,
  TRAIN_SOURCE varchar(100) NOT NULL,
  TRAIN_DESTINATION varchar(100) NOT NULL,
  SOURCE_TIME timestamp NOT NULL,
  DESTINATION_TIME timestamp NOT NULL,
  TOTAL_SEAT int NOT NULL,
  AVAILABLE_SEAT int NOT NULL,
  TICKET_PRICE int NOT NULL,

  CONSTRAINT pk_trainid PRIMARY KEY (train_Id)
  );


CREATE TABLE BOOKING_DETAILS (
  BOOKING_ID NUMBER GENERATED ALWAYS AS IDENTITY START WITH 3000 increment by 1,
  PNR_NUMBER int NOT NULL UNIQUE,
  USER_ID int NOT NULL,
  TRAIN_ID int NOT NULL,
  TRAIN_SOURCE varchar(100) NOT NULL,
  TRAIN_DESTINATION varchar(100) NOT NULL,
  JOURNEY_DATE date NOT NULL,
  BOOKING_DATE date NOT NULL,
  TICKET_COUNT int NOT NULL,
  TOTAL_PRICE int,
  
  CONSTRAINT pk_bookingid PRIMARY KEY (Booking_Id),
  CONSTRAINT fk_booking_userid FOREIGN KEY (user_Id) REFERENCES users (user_Id) ,
  CONSTRAINT fk_booking_trainid FOREIGN KEY (train_Id) REFERENCES trains (train_Id) 
);

CREATE TABLE USERS (
  USER_ID  NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1 ,
  USER_NAME varchar(40) NOT NULL,
  USER_AGE int NOT NULL,
  USER_EMAIL varchar(30) NOT NULL ,
  USER_MOBILENUMBER varchar(30) NOT NULL,
  USER_GENDER varchar(30) NOT NULL,
  USER_PASSWORD varchar(50) NOT NULL ,
  
  CONSTRAINT pk_userid PRIMARY KEY (user_id),
  CONSTRAINT unique_user UNIQUE (user_email, user_mobilenumber)
);


CREATE TABLE ADMINS (
 ADMIN_ID NUMBER GENERATED ALWAYS AS IDENTITY START WITH 200 increment by 1 ,
 ADMIN_NAME varchar(128) NOT NULL,
 ADMIN_PASSWORD varchar(128) NOT NULL ,
 ADMIN_EMAIL varchar(128) NOT NULL,
 
 CONSTRAINT pk_adminid primary key (Admin_Id),
 CONSTRAINT unique_admin UNIQUE (Admin_Email,Admin_Password)
 );
drop table users;
truncate table users;
select * from users;

--select * from admins;
select * from trains;
--select * from booking_details;
--
--
--drop table users cascade constraint;
--drop table admins cascade constraint;
--drop table trains cascade constraint;
--drop table booking_details cascade constraint;

insert into admins (ADMIN_NAME, ADMIN_PASSWORD,ADMIN_EMAIL)values('dhivakar','hello','dhivaadmin@gmail.com');


select * from users;
select * from users where user_mobilenumber='8181634782';
drop table users cascade constraints;