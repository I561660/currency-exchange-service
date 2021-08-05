CREATE TABLE exchange_value (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  currency_from VARCHAR(250) NOT NULL,
  currency_to VARCHAR(250) NOT NULL,
  convertion_multiple VARCHAR(250) DEFAULT NULL,
  port VARCHAR(250) NOT NULL
);



INSERT INTO exchange_value(id, currency_from ,currency_to, convertion_multiple, port)
VALUES (10001, 'USD', 'INR', '65', 20);
INSERT INTO exchange_value(id, currency_from ,currency_to, convertion_multiple, port)
VALUES (10002, 'USD', 'CHN', '6.5', 20);
INSERT INTO exchange_value(id, currency_from ,currency_to, convertion_multiple, port)
VALUES (10003, 'EUR', 'INR', '70', 20);
commit;