-- -----------------------------------------------------
-- Insert table orders
-- -----------------------------------------------------
INSERT INTO orders (order_id, account_id, order_status)
            VALUES (1, 1, 'CONFIRMED');
INSERT INTO orders (order_id, account_id, order_status)
            VALUES (2, 2, 'CONFIRMED');
INSERT INTO orders (order_id, account_id, order_status)
            VALUES (3, 3, 'CANCELLED');
INSERT INTO orders (order_id, account_id, order_status)
            VALUES (4, 4, 'CANCELLED');
INSERT INTO orders (order_id, account_id, order_status)
            VALUES (5, 5, 'PENDING');
INSERT INTO orders (order_id, account_id, order_status)
            VALUES (6, 6, 'PENDING');

-- -----------------------------------------------------
-- Insert table parking
-- -----------------------------------------------------
INSERT INTO parking_space (parking_space_id, address, level, number_space, order_id)
            VALUES (1, '23 Industrial Blvd', '1', 'A101', 1);
INSERT INTO parking_space (parking_space_id, address, level, number_space, order_id)
            VALUES (2, '23 Industrial Blvd', '2', 'B202', 2);
INSERT INTO parking_space (parking_space_id, address, level, number_space, order_id)
            VALUES (3, '23 Industrial Blvd', '3', 'C303', 3);
INSERT INTO parking_space (parking_space_id, address, level, number_space, order_id)
            VALUES (4, '23 Industrial Blvd', '4', 'D404', 4);
INSERT INTO parking_space (parking_space_id, address, level, number_space, order_id)
            VALUES (5, '23 Industrial Blvd', '5', 'E505', 5);
INSERT INTO parking_space (parking_space_id, address, level, number_space, order_id)
            VALUES (6, '23 Industrial Blvd', '6', 'F606', 6);

-- -----------------------------------------------------
-- Insert table invoice
-- -----------------------------------------------------
INSERT INTO invoice (invoice_id, amount, start_date_rent, end_date_rent, rental_period, payment_date, invoice_status, order_id)
            VALUES (1, 1010, '2017-11-09', '2017-11-11', 3, '2017-11-09', 'CREATED', 1);
INSERT INTO invoice (invoice_id, amount, start_date_rent, end_date_rent, rental_period, payment_date, invoice_status, order_id)
            VALUES (2, 531, '2021-04-23', '2021-04-23', 1, '2021-04-23', 'CREATED', 2);
INSERT INTO invoice (invoice_id, amount, start_date_rent, end_date_rent, rental_period, payment_date, invoice_status, order_id)
            VALUES (3, 65763, '2020-06-23', '2021-06-25', 3, '2021-06-23', 'SENT', 3);
INSERT INTO invoice (invoice_id, amount, start_date_rent, end_date_rent, rental_period, payment_date, invoice_status, order_id)
            VALUES (4, 48722, '2019-02-02', '2019-02-02', 1, '2019-02-02', 'PAID', 4);
INSERT INTO invoice (invoice_id, amount, start_date_rent, end_date_rent, rental_period, payment_date, invoice_status, order_id)
            VALUES (5, 2643, '2021-04-22', '2021-04-26', 5, '2021-04-21', 'PAID', 5);
INSERT INTO invoice (invoice_id, amount, start_date_rent, end_date_rent, rental_period, payment_date, invoice_status, order_id)
            VALUES (6, 663, '2021-06-20', '2021-06-20', 1, '2021-06-20', 'SENT', 6);

COMMIT;