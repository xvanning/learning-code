DROP DATABASE IF EXISTS mldn ;
CREATE DATABASE mldn CHARACTER SET UTF8 ;
USE mldn ;
CREATE TABLE member(
	mid			VARCHAR(50) ,
	name		VARCHAR(50) ,
	age			INT ,
	salary		DOUBLE ,
	birthday	DATETIME ,
	note		TEXT ,
	CONSTRAINT pk_mid PRIMARY KEY(mid)
) ;