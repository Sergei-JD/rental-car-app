-- -----------------------------------------------------
-- Table users
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS users
(
    user_id                  BIGSERIAL PRIMARY KEY,
    first_name               VARCHAR(256)        NOT NULL,
    last_name                VARCHAR(256)        NOT NULL,
    date_of_birth            TIMESTAMP           NOT NULL,
    identity_passport_number VARCHAR(14)         NOT NULL,
    email                    VARCHAR(256) UNIQUE NOT NULL,
    password                 VARCHAR(256)        NOT NULL,
    gender                   VARCHAR(64)         NOT NULL,
    role                     VARCHAR(64)         NOT NULL
);

-- -----------------------------------------------------
-- Table account
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS account
(
    account_id   BIGSERIAL PRIMARY KEY,
    user_id      BIGINT       NOT NULL UNIQUE references users (user_id),
    nick_name    VARCHAR(256) NOT NULL,
    password     VARCHAR(256) NOT NULL,
    phone_number BIGINT       NOT NULL
);

-- -----------------------------------------------------
-- Table credit_card
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS credit_card
(
    credit_card_id   BIGSERIAL PRIMARY KEY,
    credit_card_type VARCHAR(128) NOT NULL,
    card_number      VARCHAR(16)  NOT NULL,
    date_of_issue    TIMESTAMP    NOT NULL,
    expiration_date  TIMESTAMP    NOT NULL,
    cvv_code         VARCHAR(3)   NOT NULL,
    name_card_owner  VARCHAR(256) NOT NULL,
    balance          NUMERIC,
    account_id       BIGINT       NOT NULL REFERENCES account (account_id)
);

-- -----------------------------------------------------
-- Table driver_license
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS driver_license
(
    driver_license_id     BIGSERIAL PRIMARY KEY,
    driver_license_number VARCHAR(32) NOT NULL,
    category              VARCHAR(32) NOT NULL,
    date_of_issue         TIMESTAMP   NOT NULL,
    expiration_date       TIMESTAMP   NOT NULL,
    account_id            BIGINT      NOT NULL REFERENCES account (account_id)
);

COMMIT;
