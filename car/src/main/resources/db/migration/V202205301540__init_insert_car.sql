-- -----------------------------------------------------
-- Insert table user
-- -----------------------------------------------------
INSERT INTO car_catalog (car_catalog_id, registration_number, car_type, year_of_manufacture, make, model, colour, price, car_status)
            VALUES (1, 'AA-1111', 'COUPE', 2019, 'BMW', '6-SERIES', 'BLACK', 65.30, 'READY');
INSERT INTO car_catalog (car_catalog_id, registration_number, car_type, year_of_manufacture, make, model, colour, price, car_status)
            VALUES (2, 'BB-2222', 'SUV', 2020, 'MERCEDES', 'GL', 'RED', 71.00, 'READY');
INSERT INTO car_catalog (car_catalog_id, registration_number, car_type, year_of_manufacture, make, model, colour, price, car_status)
            VALUES (3, 'CC-3333', 'SEDAN', 2015, 'SKODA', 'OCTAVIA', 'GREEN', 35.30, 'RENT');
INSERT INTO car_catalog (car_catalog_id, registration_number, car_type, year_of_manufacture, make, model, colour, price, car_status)
            VALUES (4, 'DD-4444', 'SEDAN', 2019, 'VOLKSWAGEN', 'POLO', 'BLUE', 25.30, 'READY');
INSERT INTO car_catalog (car_catalog_id, registration_number, car_type, year_of_manufacture, make, model, colour, price, car_status)
            VALUES (5, 'EE-5555', 'SEDAN', 2019, 'BMW', '3-SERIES', 'WHITE', 40.00, 'WASH');
INSERT INTO car_catalog (car_catalog_id, registration_number, car_type, year_of_manufacture, make, model, colour, price, car_status)
            VALUES (6, 'FF-6666', 'SUV', 2019, 'RENAULT', 'DUSTER', 'YELLOW', 25.30, 'REPAIR');

COMMIT;