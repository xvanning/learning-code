USE mldn;
CREATE TABLE persistent_logins (
	series		VARCHAR(64),
	username	VARCHAR(100) NOT NULL,
	token		VARCHAR(64),
	last_used	DATETIME,
	CONSTRAINT	pk_series PRIMARY KEY(series)
);