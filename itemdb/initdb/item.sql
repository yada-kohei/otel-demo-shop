USE item;

DROP TABLE IF EXISTS item;
CREATE TABLE item(
	item_id int PRIMARY KEY,
	item_name VARCHAR(50),
	description VARCHAR(100),
	price int
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