USE demo;

DROP TABLE IF EXISTS user;
CREATE TABLE user(
	user_id VARCHAR(50) PRIMARY KEY,
	password VARCHAR(100),
	user_name VARCHAR(50),
	birthday DATE,
	age INT,
	marriage BOOLEAN,
	role VARCHAR(50)
);

INSERT INTO user
(
  user_id,
  password,
  user_name,
  birthday,
  age,
  marriage,
  role
)
VALUES
(
  'test@example.com',
  '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa',
  'test',
  '1990-01-01',
  28,
  false,
  'ROLE_ADMIN'
);

INSERT INTO user
(
  user_id,
  password,
  user_name,
  birthday,
  age,
  marriage,
  role
)
VALUES
(
  'admin@example.com',
  '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa',
  'admin',
  '1995-03-03',
  35,
  true,
  'ROLE_ADMIN'
);

INSERT INTO user
(
  user_id,
  password,
  user_name,
  birthday,
  age,
  marriage,
  role
)
VALUES
(
  'general@example.com',
  '$2a$10$xRTXvpMWly0oGiu65WZlm.3YL95LGVV2ASFjDhe6WF4.Qji1huIPa',
  'general',
  '2000-05-05',
  21,
  false,
  'ROLE_GENERAL'
);