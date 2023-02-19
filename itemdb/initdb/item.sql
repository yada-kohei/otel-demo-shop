USE item;

DROP TABLE IF EXISTS shopping;
DROP TABLE IF EXISTS item;
CREATE TABLE item(
	item_id int PRIMARY KEY,
	item_name VARCHAR(50),
	description VARCHAR(100),
	price int
);

CREATE TABLE shopping(
  id int PRIMARY KEY AUTO_INCREMENT,
  item_id int,
  user_id VARCHAR(50),
  unit int,
  created_at timestamp not null default current_timestamp,
  FOREIGN KEY fk_itemid (item_id) references item(item_id),
  INDEX(id)
);

INSERT INTO item
(
  item_id,
  item_name,
  description,
  price
)
VALUES
(
  1,
  'OpenTelemetry',
  'CNCF Project',
  0
);

INSERT INTO item
(
  item_id,
  item_name,
  description,
  price
)
VALUES
(
  2,
  'INSTANA',
  'IBM Observability Product',
  80
);

INSERT INTO item
(
  item_id,
  item_name,
  description,
  price
)
VALUES
(
  3,
  'Datadog',
  'Major Product',
  50
);

INSERT INTO item
(
  item_id,
  item_name,
  description,
  price
)
VALUES
(
  4,
  'New Relic',
  'Recently Popular',
  70
);

INSERT INTO shopping
(
  item_id,
  user_id,
  unit
)
VALUES
(
  1,
  'test@example.com',
  2
);

INSERT INTO shopping
(
  item_id,
  user_id,
  unit
)
VALUES
(
  1,
  'general@example.com',
  1
);