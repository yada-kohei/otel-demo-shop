USE user;

DROP TABLE IF EXISTS user;
CREATE TABLE user(
	user_id VARCHAR(50) PRIMARY KEY,
	password VARCHAR(100),
	user_name VARCHAR(50),
	role VARCHAR(50)
);

INSERT INTO user
(
  user_id,
  password,
  user_name,
  role
)
VALUES
(
  'test@example.com',
  'password',
  'test',
  'ROLE_ADMIN'
);

INSERT INTO user
(
  user_id,
  password,
  user_name,
  role
)
VALUES
(
  'admin@example.com',
  'password',
  'admin',
  'ROLE_ADMIN'
);

INSERT INTO user
(
  user_id,
  password,
  user_name,
  role
)
VALUES
(
  'general@example.com',
  'password',
  'general',
  'ROLE_GENERAL'
);