/*
 Sample data generation script
  */


/******* customer ********/
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO customer (customer_id, full_name, email, phone_number, points, birth_date)
VALUES
  (uuid_generate_v4(), 'Test User 1', 'test.user1@sample.com', '+123456789', 500, to_date('10-09-1981', 'DD-MM-YYYY')),
  (uuid_generate_v4(), 'Test User 2', 'test.user2@sample.com', '+123456789', 500, to_date('10-09-1982', 'DD-MM-YYYY')),
  (uuid_generate_v4(), 'Test User 3', 'test.user3@sample.com', '+123456789', 500, to_date('10-09-1983', 'DD-MM-YYYY')),
  (uuid_generate_v4(), 'Test User 4', 'test.user4@sample.com', '+123456789', 500, to_date('10-09-1984', 'DD-MM-YYYY')),
  (uuid_generate_v4(), 'Test User 5', 'test.user5@sample.com', '+123456789', 500, to_date('10-09-1985', 'DD-MM-YYYY'));

INSERT INTO transaction (transaction_id, description, points, customer_customer_id, type)
VALUES (uuid_generate_v4(), 'Purchase transaction #1', 100, (SELECT customer_id
                                                             FROM customer
                                                             WHERE email = 'test.user1@sample.com'), 'PURCHASE'),
  (uuid_generate_v4(), 'Purchase transaction #2', 50, (SELECT customer_id
                                                       FROM customer
                                                       WHERE email = 'test.user1@sample.com'), 'PURCHASE'),
  (uuid_generate_v4(), 'Redeem transaction #1', 130, (SELECT customer_id
                                                      FROM customer
                                                      WHERE email = 'test.user1@sample.com'), 'REDEEM');

/******* user ********/
INSERT INTO public.user (username, fullname, password, type)
VALUES ('pera@pera.com', 'Pera Peric', '$2a$06$XFRi7iKwKbvoar/gAUykBebYyWMbMRR3plBvZCQU1dOapyLqXlALG', 'ADMIN');


/******* user ********/
INSERT INTO voucher (voucher_id, name, description, points, active, expiry_date)
VALUES (nextval('voucher_seq'), 'Sample voucher #1', 'This voucher will provider 20% discount', 130, TRUE,
        now() + INTERVAL '1 day'),
  (nextval('voucher_seq'), 'Sample voucher #2', 'This voucher will provider 50% discount', 500, TRUE,
   now() + INTERVAL '2 day'),
  (nextval('voucher_seq'), 'Sample voucher #3', 'This voucher will provider CHF 50 valued gift', 200, TRUE,
   now() + INTERVAL '10 day');