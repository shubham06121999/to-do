
use spartanapp
--DROP TABLE IF EXISTS
DROP TABLE IF EXISTS ORGINIZATION;

-- ORGINIZATION table
CREATE TABLE   ORGINIZATION(
ID VARCHAR(36) PRIMARY KEY,
USERID VARCHAR(36),
NAME VARCHAR(20),
ACTION VARCHAR(20),
CREATED_DTTM DATETIMEOFFSET(7),
UPDATED_DTTM DATETIMEOFFSET(7),
IS_DELETED bit);


--DROP TABLE IF EXISTS
DROP TABLE IF EXISTS CATEGORY;

-- CATEGORY table
CREATE TABLE   CATEGORY(
ID VARCHAR(36) PRIMARY KEY,
NAME VARCHAR(20) NOT NULL ,
USERID VARCHAR(36),
ORGANIZATIONID VARCHAR(36),
ACTION VARCHAR(20) NOT NULL,
CREATED_DTTM DATETIMEOFFSET(7),
UPDATED_DTTM DATETIMEOFFSET(7),
IS_DELETED bit);


--DROP TABLE IF EXISTS
DROP TABLE IF EXISTS TASK;

-- TASK table
CREATE TABLE   TASK(
ID VARCHAR(36) PRIMARY KEY,
NAME VARCHAR(20) NOT NULL ,
USERID VARCHAR(36),
ORGANIZATIONID VARCHAR(36),
STATUSID VARCHAR(36),
TITLE VARCHAR(50),
DESCRIPTION VARCHAR(150),
DUEDATE DATETIMEOFFSET(7),
ACTION VARCHAR(20) NOT NULL,
CREATED_DTTM DATETIMEOFFSET(7),
UPDATED_DTTM DATETIMEOFFSET(7),
IS_DELETED bit);


--DROP TABLE IF EXISTS
DROP TABLE IF EXISTS STATUS;

-- STATUS table
CREATE TABLE   STATUS(
ID VARCHAR(36) PRIMARY KEY,
NAME VARCHAR(20) NOT NULL ,
COLOR VARCHAR(36));