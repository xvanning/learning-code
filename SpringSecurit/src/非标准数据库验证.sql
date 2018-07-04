USE mldn;
DROP TABLE IF EXISTS role; 
DROP TABLE IF EXISTS member;
CREATE TABLE member (
	mid				VARCHAR(50),
	password		VARCHAR(32) NOT NULL,
	enabled			INT,
	CONSTRAINT	pk_mid PRIMARY KEY(mid)
)ENGINE=innodb;

CREATE TABLE role (
	mid			VARCHAR(50),
	title		VARCHAR(30),
	CONSTRAINT	fk_mid FOREIGN KEY(mid) REFERENCES member(mid) ON DELETE CASCADE
)ENGINE=innodb;

--增加用户信息：admin / hello
INSERT INTO member(mid,password,enabled) VALUES ('admin','5d41402abc4b2a76b9719d911017c592',1);
INSERT INTO member(mid,password,enabled) VALUES ('mldn','93f725a07423fe1c889f448b33d21f46',1);
INSERT INTO role(mid,title) VALUES ('admin',"ROLE_ADMIN");
INSERT INTO role(mid,title) VALUES ('admin',"ROLE_USER");
INSERT INTO role(mid,title) VALUES ('mldn',"ROLE_USER");