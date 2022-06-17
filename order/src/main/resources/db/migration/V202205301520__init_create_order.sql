-- -----------------------------------------------------
-- Table invoice
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS invoice
(
    id              BIGSERIAL PRIMARY KEY,
    amount          NUMERIC CHECK (invoice.amount >= 0),
    start_date_rent TIMESTAMP   NOT NULL,
    end_date_rent   TIMESTAMP   NOT NULL CHECK (invoice.end_date_rent >= invoice.start_date_rent),
    rental_period   INTEGER     NOT NULL CHECK (invoice.rental_period > 0),
    payment_date    TIMESTAMP   NOT NULL,
    invoice_status  VARCHAR(64) NOT NULL
);

-- -----------------------------------------------------
-- Table orders
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS orders
(
    id           BIGSERIAL PRIMARY KEY,
    account_id   BIGINT        NOT NULL,
    invoice_id   BIGINT UNIQUE NOT NULL,
    order_status VARCHAR(64)   NOT NULL
);


-- -----------------------------------------------------
-- Table parking
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS parking_space
(
    id           BIGSERIAL PRIMARY KEY,
    address      VARCHAR(256) NOT NULL,
    level        VARCHAR(8)   NOT NULL,
    number_space VARCHAR(8)   NOT NULL,
    order_id     BIGINT       NOT NULL REFERENCES orders (id)
);

-- -----------------------------------------------------
-- Table reservation
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS reservation
(
    id                 BIGSERIAL PRIMARY KEY,
    order_id           BIGINT      NOT NULL REFERENCES orders (id),
    car_catalog_id     BIGINT      NOT NULL,
    pick_up_date_time  TIMESTAMP   NOT NULL,
    drop_off_date_time TIMESTAMP   NOT NULL,
    reservation_status VARCHAR(64) NOT NULL
);

COMMIT;

