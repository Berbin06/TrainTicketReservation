CREATE TABLE TRAINS (
  TRAIN_ID NUMBER GENERATED ALWAYS AS IDENTITY START WITH 2000 increment by 1,
 
  TRAIN_NAME varchar(50) NOT NULL,
  TRAIN_CLASS varchar(50) NOT NULL,
  TRAIN_NUMBER int NOT NULL,
  TRAIN_SOURCE varchar(100) NOT NULL,
  TRAIN_DESTINATION varchar(100) NOT NULL,
  TRAIN_DEPARTURE_TIME timestamp NOT NULL,
  TRAIN_ARRAIVAL_TIME timestamp NOT NULL,
  TOTAL_SEAT int NOT NULL,
  TICKET_PRICE int NOT NULL,

  CONSTRAINT pk_trainid PRIMARY KEY (train_Id),
  CONSTRAINT train_number unique(train_number)
  );


CREATE TABLE BOOKING_DETAILS (
  USER_ID int NOT NULL,
  TRAIN_ID int NOT NULL,
  PNR_NUMBER number generated always as identity start with 60000 increment by 3,
  JOURNEY_DATE date NOT NULL,
  BOOKING_DATE date default SYSDATE,
  TICKET_COUNT int NOT NULL,
  TOTAL_PRICE int,
  TICKET_STATUS varchar(20) default 'BOOKED',
  
  CONSTRAINT pk_bookingid PRIMARY KEY (PNR_NUMBER),
  CONSTRAINT fk_booking_userid FOREIGN KEY (user_Id) REFERENCES users (user_Id) ,
  CONSTRAINT fk_booking_trainid FOREIGN KEY (train_Id) REFERENCES trains (train_Id)
  
);

CREATE TABLE USERS (
  USER_ID  NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1 ,
  USER_NAME varchar(40) NOT NULL,
  USER_DOB DATE NOT NULL,
  USER_EMAIL varchar(30) NOT NULL ,
  USER_MOBILENUMBER varchar(30) NOT NULL,
  USER_GENDER varchar(30) NOT NULL,
  USER_PASSWORD varchar(50) NOT NULL ,
  USER_WALLET int default 0,
  
  
  CONSTRAINT pk_userid PRIMARY KEY (user_id),
  CONSTRAINT unique_user UNIQUE (user_email, user_mobilenumber)
);

CREATE TABLE ADMINS (
 ADMIN_ID int GENERATED ALWAYS AS IDENTITY START WITH 1,
 ADMIN_NAME varchar(50) NOT NULL,
 ADMIN_MOBILENUMBER int NOT NULL,
 ADMIN_PASSWORD varchar(50) NOT NULL ,
 ADMIN_EMAIL varchar(50) NOT NULL,
 
 CONSTRAINT pk_adminid primary key (Admin_Id),
 CONSTRAINT unique_admin UNIQUE (Admin_Email)
 );
 insert into admins (admin_name,admin_mobilenumber,admin_password,admin_email)values('Robert',9486209572,'Qwerty@123','robertadmin@admin.com');

select * from admins;
select * from booking_details;
drop table users cascade constraint;
drop table admins cascade constraint;
drop table trains cascade constraint;
drop table booking_details cascade constraint;

select * from users;    
commit;
select * from trains;
select * from admins;
select * from booking_details;
commit;
desc trains;
select*from trains;
drop table users cascade constraints;
desc trains;
select*from trains where to_char(train_departure_time,'dd-mm-yyyy')='30-12-2021' and train_source='madurai' and train_destination='chennai';
resultset

select*from trains where train_departure_time='2021-12-30 08:20:00' and train_source='madurai' and train_destination='chennai';
select*from trains where to_char(train_departure_time,'dd-mm-yyyy')='30-12-2021' and train_source='Madurai' and train_destination='Chennai';

update users set user_wallet=10000 where user_id = 42;