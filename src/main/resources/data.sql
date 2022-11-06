CREATE TABLE IF NOT EXISTS operation_type (
    operation_type_id BIGINT IDENTITY PRIMARY KEY,
    description VARCHAR(255) UNIQUE
);

INSERT INTO operation_type (description)
    SELECT * FROM (SELECT 'PURCHASE') AS tmp
WHERE NOT EXISTS (
    SELECT description FROM operation_type WHERE description = 'PURCHASE'
);

INSERT INTO operation_type (description)
SELECT * FROM (SELECT 'INSTALLMENT PURCHASE') AS tmp
WHERE NOT EXISTS (
        SELECT description FROM operation_type WHERE description = 'INSTALLMENT PURCHASE'
);

INSERT INTO operation_type (description)
SELECT * FROM (SELECT 'WITHDRAWAL') AS tmp
WHERE NOT EXISTS (
        SELECT description FROM operation_type WHERE description = 'WITHDRAWAL'
);

INSERT INTO operation_type (description)
SELECT * FROM (SELECT 'PAYMENT') AS tmp
WHERE NOT EXISTS (
        SELECT description FROM operation_type WHERE description = 'PAYMENT'
);

CREATE TABLE IF NOT EXISTS account (
    account_id BIGINT IDENTITY PRIMARY KEY,
    document_number VARCHAR(14) UNIQUE
);

INSERT INTO account (document_number)
SELECT * FROM (SELECT '12345678900') AS tmp
WHERE NOT EXISTS (
        SELECT document_number FROM account WHERE document_number = '12345678900'
);

CREATE TABLE IF NOT EXISTS transaction (
    transaction_id BIGINT IDENTITY PRIMARY KEY,
    account_id BIGINT,
    operation_type_id BIGINT,
    amount DECIMAL(15, 2),
    event_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES account(account_id),
    FOREIGN KEY (operation_type_id) REFERENCES operation_type(operation_type_id)
);