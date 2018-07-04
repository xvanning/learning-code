USE mldn;
DROP TABLE IF EXISTS authorities; 
DROP TABLE IF EXISTS users;
CREATE TABLE users (
	username		VARCHAR(50),
	password		VARCHAR(32) NOT NULL,
	enabled			INT,
	CONSTRAINT	pk_username PRIMARY KEY(username)
)ENGINE=innodb;

CREATE TABLE authorities (
	username		VARCHAR(50),
	authority		VARCHAR(30),
	CONSTRAINT	fk_username FOREIGN KEY(username) REFERENCES users(username) ON DELETE CASCADE
)ENGINE=innodb;

--增加用户信息：admin / hello
INSERT INTO users(username,password,enabled) VALUES ('admin','5d41402abc4b2a76b9719d911017c592',1);
INSERT INTO users(username,password,enabled) VALUES ('mldn','93f725a07423fe1c889f448b33d21f46',1);
INSERT INTO authorities(username,authority) VALUES ('admin',"ROLE_ADMIN");
INSERT INTO authorities(username,authority) VALUES ('admin',"ROLE_USER");
INSERT INTO authorities(username,authority) VALUES ('mldn',"ROLE_USER");