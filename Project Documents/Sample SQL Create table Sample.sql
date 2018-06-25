CREATE DATABASE DCA;

USE DCA;

CREATE TABLE claims (
  id int NOT NULL,
  mem_id varchar(20) NOT NULL,
  date date NOT NULL,
  rationale MEDIUMTEXT NOT NULL,
  status varchar(10) NOT NULL,
  amount float NOT NULL,
  PRIMARY KEY(id)
);

TRUNCATE TABLE claims;

CREATE TABLE members (
  id varchar(20)  NOT NULL,
  name varchar(40),
  address MEDIUMTEXT,
  dob date DEFAULT NULL,
  dor date DEFAULT NULL,
  status varchar(10) NOT NULL,
  balance float NOT NULL,
  PRIMARY KEY(id)
);


TRUNCATE TABLE members;

CREATE TABLE payments (
  id int NOT NULL,
  mem_id varchar(20) NOT NULL,
  type_of_payment char(10) NOT NULL,
  amount float NOT NULL,
  date date NOT NULL,
  time time Not Null,
  PRIMARY KEY(id)
);

TRUNCATE TABLE payments;

CREATE TABLE users (
  id varchar(20) NOT NULL,
  password varchar(20) NOT NULL,
  status char(10) NOT NULL,
  PRIMARY KEY(id)
);


TRUNCATE TABLE users;
