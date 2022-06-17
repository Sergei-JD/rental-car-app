-- -----------------------------------------------------
-- Insert table invoice
-- -----------------------------------------------------
INSERT INTO invoice (amount, start_date_rent, end_date_rent, rental_period, payment_date, invoice_status)
            VALUES (1010, '2017-11-09', '2017-11-11', 3, '2017-11-09', 'CREATED');
INSERT INTO invoice (amount, start_date_rent, end_date_rent, rental_period, payment_date, invoice_status)
            VALUES (531, '2021-04-23', '2021-04-23', 1, '2021-04-23', 'CREATED');
INSERT INTO invoice (amount, start_date_rent, end_date_rent, rental_period, payment_date, invoice_status)
            VALUES (65763, '2020-06-23', '2021-06-25', 3, '2021-06-23', 'SENT');
INSERT INTO invoice (amount, start_date_rent, end_date_rent, rental_period, payment_date, invoice_status)
            VALUES (48722, '2019-02-02', '2019-02-02', 1, '2019-02-02', 'PAID');
INSERT INTO invoice (amount, start_date_rent, end_date_rent, rental_period, payment_date, invoice_status)
            VALUES (2643, '2021-04-22', '2021-04-26', 5, '2021-04-21', 'PAID');
INSERT INTO invoice (amount, start_date_rent, end_date_rent, rental_period, payment_date, invoice_status)
            VALUES (663, '2021-06-20', '2021-06-20', 1, '2021-06-20', 'SENT');

-- -----------------------------------------------------
-- Insert table orders
-- -----------------------------------------------------
INSERT INTO orders (account_id, invoice_id, order_status)
            VALUES (1, 1, 'CONFIRMED');
INSERT INTO orders (account_id, invoice_id, order_status)
            VALUES (2, 2, 'CONFIRMED');
INSERT INTO orders (account_id, invoice_id, order_status)
            VALUES (3, 3, 'CANCELLED');
INSERT INTO orders (account_id, invoice_id, order_status)
            VALUES (4, 4, 'CANCELLED');
INSERT INTO orders (account_id, invoice_id, order_status)
            VALUES (5, 5, 'PENDING');
INSERT INTO orders (account_id, invoice_id, order_status)
            VALUES (6, 6, 'PENDING');

-- -----------------------------------------------------
-- Insert table parking
-- -----------------------------------------------------
INSERT INTO parking_space (address, level, number_space, order_id)
            VALUES ('23 Industrial Blvd', '1', 'A101', 1);
INSERT INTO parking_space (address, level, number_space, order_id)
            VALUES ('23 Industrial Blvd', '2', 'B202', 2);
INSERT INTO parking_space (address, level, number_space, order_id)
            VALUES ('23 Industrial Blvd', '3', 'C303', 3);
INSERT INTO parking_space (address, level, number_space, order_id)
            VALUES ('23 Industrial Blvd', '4', 'D404', 4);
INSERT INTO parking_space (address, level, number_space, order_id)
            VALUES ('23 Industrial Blvd', '5', 'E505', 5);
INSERT INTO parking_space (address, level, number_space, order_id)
            VALUES ('23 Industrial Blvd', '6', 'F606', 6);

-- -----------------------------------------------------
-- Insert table reservation
-- -----------------------------------------------------
INSERT INTO reservation (order_id, car_catalog_id, pick_up_date_time, drop_off_date_time, reservation_status)
            VALUES (1, 1, '2017-11-09', '2017-11-11', 'FREE');
INSERT INTO reservation (order_id, car_catalog_id, pick_up_date_time, drop_off_date_time, reservation_status)
            VALUES (2, 2, '2021-04-23', '2021-04-23', 'FREE');
INSERT INTO reservation (order_id, car_catalog_id, pick_up_date_time, drop_off_date_time, reservation_status)
            VALUES (3, 3, '2021-06-25', '2021-06-23', 'FREE');
INSERT INTO reservation (order_id, car_catalog_id, pick_up_date_time, drop_off_date_time, reservation_status)
            VALUES (4, 4, '2022-06-14', '2022-06-20', 'BOOKED');
INSERT INTO reservation (order_id, car_catalog_id, pick_up_date_time, drop_off_date_time, reservation_status)
            VALUES (5, 5, '2022-06-12', '2022-06-15', 'BOOKED');
INSERT INTO reservation (order_id, car_catalog_id, pick_up_date_time, drop_off_date_time, reservation_status)
            VALUES (6, 6, '2022-06-13', '2022-06-26', 'BOOKED');

COMMIT;