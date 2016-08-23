
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

insert into customer (customer_id, full_name, email, phone_number, points, birth_date)
values (uuid_generate_v4(),'Test User 1', 'test.user1@sample.com', '+123456789', 500, to_date('10-09-1981', 'DD-MM-YYYY')),
        (uuid_generate_v4(),'Test User 2', 'test.user2@sample.com', '+123456789', 500, to_date('10-09-1982', 'DD-MM-YYYY')),
        (uuid_generate_v4(),'Test User 3', 'test.user3@sample.com', '+123456789', 500, to_date('10-09-1983', 'DD-MM-YYYY')),
        (uuid_generate_v4(),'Test User 4', 'test.user4@sample.com', '+123456789', 500, to_date('10-09-1984', 'DD-MM-YYYY')),
        (uuid_generate_v4(),'Test User 5', 'test.user5@sample.com', '+123456789', 500, to_date('10-09-1985', 'DD-MM-YYYY'));