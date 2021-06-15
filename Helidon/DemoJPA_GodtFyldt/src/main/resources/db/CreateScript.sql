USE JPA_DEMO;

CREATE TABLE DB_USER(
	id varchar(40) primary key,
	name varchar(40) NOT NULL,
	email varchar(40) NOT NULL,
	address_fk varchar(40) NOT NULL
);

CREATE TABLE ADDRESS(
	id varchar(40) primary key,
	street varchar(40) NOT NULL,
	city varchar(40) NOT NULL
);

CREATE TABLE CART(
	id varchar(40) primary key,
	name varchar(40) NOT NULL
);

CREATE TABLE ITEM(
	id varchar(40) primary key,
	name varchar(40) NOT NULL,
	price decimal(10,2) NOT NULL,
	CART_FK varchar(40) foreign key references CART(id) NOT NULL
);

create table PROJECT(
id varchar(40) primary key,
title varchar(40) not null ,
);

create table EMPLOYEE(
id varchar(40) primary key,
name varchar(40) not null ,
);

create table EMPLOYEE_PROJECT(
PROJECT_FK varchar(40) not null ,
EMPLOYEE_FK varchar(40) not null
primary key(PROJECT_FK,EMPLOYEE_FK)
);
