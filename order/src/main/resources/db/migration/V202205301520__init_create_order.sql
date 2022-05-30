-- -----------------------------------------------------
-- Table orders
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS orders
(
    order_id         BIGSERIAL PRIMARY KEY,
    account_id       BIGINT      NOT NULL,
    credit_card_id   BIGINT      NOT NULL,
    order_status     VARCHAR(64) NOT NULL
    );

-- -----------------------------------------------------
-- Table invoice
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS invoice
(
    invoice_id      BIGSERIAL PRIMARY KEY,
    user_id         BIGINT      NOT NULL,
    amount          NUMERIC CHECK (invoice.amount >= 0),
    start_date_rent TIMESTAMP   NOT NULL,
    end_date_rent   TIMESTAMP   NOT NULL CHECK (invoice.end_date_rent >= invoice.start_date_rent),
    rental_period   INTEGER     NOT NULL CHECK (invoice.rental_period > 0),
    payment_date    TIMESTAMP   NOT NULL,
    invoice_status  VARCHAR(64) NOT NULL,
    order_id        BIGINT      NOT NULL
    );

-- -----------------------------------------------------
-- Table parking
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS parking_space
(
    parking_space_id BIGSERIAL PRIMARY KEY,
    address          VARCHAR(256) NOT NULL,
    level            VARCHAR(3)   NOT NULL,
    number_space     VARCHAR(5)   NOT NULL,
    order_id         BIGINT       NOT NULL
    );

-- DROP TABLE orders;
-- DROP TABLE invoice;
-- DROP TABLE parking_space;

COMMIT;

