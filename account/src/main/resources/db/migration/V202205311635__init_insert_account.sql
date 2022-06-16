-- -----------------------------------------------------
-- Insert table account
-- -----------------------------------------------------
INSERT INTO account (nick_name, password)
VALUES ('IvanavI', '1111');
INSERT INTO account (nick_name, password)
VALUES ('PetrteP', '2222');
INSERT INTO account (nick_name, password)
VALUES ('SergeyegreS', '3333');
INSERT INTO account (nick_name, password)
VALUES ('SvetatevS', '4444');
INSERT INTO account (nick_name, password)
VALUES ('VariairaV', '5555');
INSERT INTO account (nick_name, password)
VALUES ('ValentinanitnelaV', '6666');

-- -----------------------------------------------------
-- Insert table users
-- -----------------------------------------------------
INSERT INTO users (first_name, last_name, date_of_birth, identity_passport_number, email, phone_number, gender, role, account_id)
VALUES ('Ivan', 'Ivanov', '1999-06-21', '65634234235475', 'ivan@email.com', '+375292342345', 'MALE', 'ADMIN', 1);
INSERT INTO users (first_name, last_name, date_of_birth, identity_passport_number, email, phone_number, gender, role, account_id)
VALUES ('Petr', 'Petrov', '2001-06-21', '65634234235475', 'petr@email.com', '+375332342332', 'MALE', 'CUSTOMER', 2);
INSERT INTO users (first_name, last_name, date_of_birth, identity_passport_number, email, phone_number, gender, role, account_id)
VALUES ('Sergey', 'Sergeev', '1998-06-21', '65634234235475', 'sergey@email.com', '+375442342352', 'MALE', 'MECHANIC', 3);
INSERT INTO users (first_name, last_name, date_of_birth, identity_passport_number, email, phone_number, gender, role, account_id)
VALUES ('Sveta', 'Svetikova', '1983-06-21', '65634234235475', 'sveta@email.com', '+375292348653', 'FEMALE', 'CUSTOMER', 4);
INSERT INTO users (first_name, last_name, date_of_birth, identity_passport_number, email, phone_number, gender, role, account_id)
VALUES ('Maria', 'Marieva', '1984-06-21', '65634234235475', 'maria@email.com', '+375332342354', 'FEMALE', 'CUSTOMER', 5);
INSERT INTO users (first_name, last_name, date_of_birth, identity_passport_number, email, phone_number, gender, role, account_id)
VALUES ('Valentina', 'Valentinova', '1978-06-21', '65634234235475', 'valentina@email.com', '+375442349369', 'FEMALE', 'CUSTOMER', 6);

-- -----------------------------------------------------
-- Insert table credit_card
-- -----------------------------------------------------
INSERT INTO credit_card (credit_card_type, card_number, date_of_issue, expiration_date, cvv_code, name_card_owner, balance, account_id)
VALUES ('AMERICAN_EXPRESS', '6753234223424623', '2015-05-19', '2025-05-19', '438', 'Ivan Ivanov', 7608, 1);
INSERT INTO credit_card (credit_card_type, card_number, date_of_issue, expiration_date, cvv_code, name_card_owner, balance, account_id)
VALUES ('VISA', '6396771750148265', '2020-03-08', '2030-03-08', '503', 'Petr Petrov', 653, 2);
INSERT INTO credit_card (credit_card_type, card_number, date_of_issue, expiration_date, cvv_code, name_card_owner, balance, account_id)
VALUES ('MASTERCARD', '4312637834536454', '2016-11-24', '2026-11-24', '987', 'Sergey Sergeev', 110367, 3);
INSERT INTO credit_card (credit_card_type, card_number, date_of_issue, expiration_date, cvv_code, name_card_owner, balance, account_id)
VALUES ('AMERICAN_EXPRESS', '9485618649047917', '2017-11-09', '2027-11-09', '44', 'Sveta Svetikova', 20124, 4);
INSERT INTO credit_card (credit_card_type, card_number, date_of_issue, expiration_date, cvv_code, name_card_owner, balance, account_id)
VALUES ('VISA', '0898024323423879', '2021-12-08', '2031-12-08', '362', 'Maria Marieva', 1430, 5);
INSERT INTO credit_card (credit_card_type, card_number, date_of_issue, expiration_date, cvv_code, name_card_owner, balance, account_id)
VALUES ('MASTERCARD', '9183179102970189', '2018-10-14', '2028-10-14', '342', 'Valentina Valentinova', 54367, 6);

-- -----------------------------------------------------
-- Insert table driver_license
-- -----------------------------------------------------
INSERT INTO driver_license (driver_license_number, category, date_of_issue, expiration_date, account_id)
            VALUES ('646324213243', 'B', '2015-05-19', '2025-05-19', 1);
INSERT INTO driver_license (driver_license_number, category, date_of_issue, expiration_date, account_id)
            VALUES ('678474325424', 'B, C', '2016-06-21', '2026-06-21', 2);
INSERT INTO driver_license (driver_license_number, category, date_of_issue, expiration_date, account_id)
            VALUES ('586787452341', 'C', '2018-11-10', '2028-11-10', 3);
INSERT INTO driver_license (driver_license_number, category, date_of_issue, expiration_date, account_id)
            VALUES ('678934523454', 'D, E', '2020-01-09', '2030-01-09', 4);
INSERT INTO driver_license (driver_license_number, category, date_of_issue, expiration_date, account_id)
            VALUES ('364523454241', 'A, B, D', '2014-04-30', '2024-04-30', 5);
INSERT INTO driver_license (driver_license_number, category, date_of_issue, expiration_date, account_id)
            VALUES ('365652343527', 'B', '2019-12-29', '2029-12-29', 6);

COMMIT;