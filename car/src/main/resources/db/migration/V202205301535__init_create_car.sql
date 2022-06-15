-- -----------------------------------------------------
-- Table catalog
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS car_catalog
(
    id                  BIGSERIAL PRIMARY KEY,
    registration_number VARCHAR(8)   NOT NULL,
    car_type            VARCHAR(32)  NOT NULL,
    year_of_manufacture VARCHAR(4)   NOT NULL,
    make                VARCHAR(128) NOT NULL,
    model               VARCHAR(128) NOT NULL,
    colour              VARCHAR(32)  NOT NULL,
    price               DECIMAL      NOT NULL,
    car_status          VARCHAR(32)  NOT NULL
);

COMMIT;
