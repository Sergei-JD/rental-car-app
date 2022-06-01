-- -----------------------------------------------------
-- Insert table users
-- -----------------------------------------------------
INSERT INTO users (user_id, first_name, last_name, date_of_birth, identity_passport_number, email, password, gender, role)
            VALUES (1, 'Ivan', 'Ivanov', '1999-06-21', '65634234235475', 'ivan@email.com', '1111', 'MALE', 'ADMIN');
INSERT INTO users (user_id, first_name, last_name, date_of_birth, identity_passport_number, email, password, gender, role)
            VALUES (2, 'Petr', 'Petrov', '2001-06-21', '65634234235475', 'petr@email.com', '2222', 'MALE', 'CUSTOMER');
INSERT INTO users (user_id, first_name, last_name, date_of_birth, identity_passport_number, email, password, gender, role)
            VALUES (3, 'Sergey', 'Sergeev', '1998-06-21', '65634234235475', 'sergey@email.com', '3333', 'MALE', 'MECHANIC');
INSERT INTO users (user_id, first_name, last_name, date_of_birth, identity_passport_number, email, password, gender, role)
            VALUES (4, 'Sveta', 'Svetikova', '1983-06-21', '65634234235475', 'sveta@email.com', '4444', 'FEMALE', 'CUSTOMER');
INSERT INTO users (user_id, first_name, last_name, date_of_birth, identity_passport_number, email, password, gender, role)
            VALUES (5, 'Maria', 'Marieva', '1984-06-21', '65634234235475', 'maria@email.com', '5555', 'FEMALE', 'CUSTOMER');
INSERT INTO users (user_id, first_name, last_name, date_of_birth, identity_passport_number, email, password, gender, role)
            VALUES (6, 'Valentina', 'Valentinova', '1978-06-21', '65634234235475', 'valentina@email.com', '6666', 'FEMALE', 'CUSTOMER');

-- -----------------------------------------------------
-- Insert table account
-- -----------------------------------------------------
INSERT INTO account (account_id, user_id, nick_name, password, phone_number)
            VALUES (1, 1, 'IvanavI', '1111', 456532342345);
INSERT INTO account (account_id, user_id, nick_name, password, phone_number)
            VALUES (2, 2, 'PetrteP', '2222', 674563235423);
INSERT INTO account (account_id, user_id, nick_name, password, phone_number)
            VALUES (3, 3, 'SergeyegreS', '3333', 623423454575);
INSERT INTO account (account_id, user_id, nick_name, password, phone_number)
            VALUES (4, 4, 'SvetatevS', '4444', 674563235423);
INSERT INTO account (account_id, user_id, nick_name, password, phone_number)
            VALUES (5, 5, 'VariairaV', '5555', 234563567364);
INSERT INTO account (account_id, user_id, nick_name, password, phone_number)
            VALUES (6, 6, 'ValentinanitnelaV', '6666', 674563235423);

-- -----------------------------------------------------
-- Insert table driver_license
-- -----------------------------------------------------
INSERT INTO driver_license (driver_license_id, driver_license_number, category, date_of_issue, expiration_date, account_id)
            VALUES (1, '646324213243', 'B', '2015-05-19', '2025-05-19', 1);
INSERT INTO driver_license (driver_license_id, driver_license_number, category, date_of_issue, expiration_date, account_id)
            VALUES (2, '678474325424', 'B, C', '2016-06-21', '2026-06-21', 2);
INSERT INTO driver_license (driver_license_id, driver_license_number, category, date_of_issue, expiration_date, account_id)
            VALUES (3, '586787452341', 'C', '2018-11-10', '2028-11-10', 3);
INSERT INTO driver_license (driver_license_id, driver_license_number, category, date_of_issue, expiration_date, account_id)
            VALUES (4, '678934523454', 'D, E', '2020-01-09', '2030-01-09', 4);
INSERT INTO driver_license (driver_license_id, driver_license_number, category, date_of_issue, expiration_date, account_id)
            VALUES (5, '364523454241', 'A, B, D', '2014-04-30', '2024-04-30', 5);
INSERT INTO driver_license (driver_license_id, driver_license_number, category, date_of_issue, expiration_date, account_id)
            VALUES (6, '365652343527', 'B', '2019-12-29', '2029-12-29', 6);

-- -----------------------------------------------------
-- Insert table credit_card
-- -----------------------------------------------------
INSERT INTO credit_card (credit_card_id, credit_card_type, card_number, date_of_issue, expiration_date, cvv_code, name_card_owner, balance, account_id)
            VALUES (1, 'AMERICAN_EXPRESS', '6753234223424623', '2015-05-19', '2025-05-19', '438', 'Ivan Ivanov', 7608, 1);
INSERT INTO credit_card (credit_card_id, credit_card_type, card_number, date_of_issue, expiration_date, cvv_code, name_card_owner, balance, account_id)
            VALUES (2, 'VISA', '6396771750148265', '2020-03-08', '2030-03-08', '503', 'Petr Petrov', 653, 2);
INSERT INTO credit_card (credit_card_id, credit_card_type, card_number, date_of_issue, expiration_date, cvv_code, name_card_owner, balance, account_id)
            VALUES (3, 'MASTERCARD', '4312637834536454', '2016-11-24', '2026-11-24', '987', 'Sergey Sergeev', 110367, 3);
INSERT INTO credit_card (credit_card_id, credit_card_type, card_number, date_of_issue, expiration_date, cvv_code, name_card_owner, balance, account_id)
            VALUES (4, 'AMERICAN_EXPRESS', '9485618649047917', '2017-11-09', '2027-11-09', '44', 'Sveta Svetikova Ivanov', 20124, 4);
INSERT INTO credit_card (credit_card_id, credit_card_type, card_number, date_of_issue, expiration_date, cvv_code, name_card_owner, balance, account_id)
            VALUES (5, 'VISA', '0898024323423879', '2021-12-08', '2031-12-08', '362', 'Maria Marieva', 1430, 5);
INSERT INTO credit_card (credit_card_id, credit_card_type, card_number, date_of_issue, expiration_date, cvv_code, name_card_owner, balance, account_id)
            VALUES (6, 'MASTERCARD', '9183179102970189', '2018-10-14', '2028-10-14', '342', 'Valentina Valentinova', 54367, 6);

COMMIT;