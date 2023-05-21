CREATE TABLE payment_type (
    id IDENTITY PRIMARY KEY,
    description varchar(50)
);

INSERT INTO payment_type (description) VALUES ('Dinheiro'), ('Cartão de Crédito'), ('Cartão de Débito'), ('Pix');

CREATE TABLE transaction_type (
    acronym varchar(1) PRIMARY KEY,
    description varchar(10)
);

INSERT INTO transaction_type (acronym, description) VALUES ('C', 'Crédito'), ('D', 'Débito');

CREATE TABLE transactions (
    id IDENTITY PRIMARY KEY,
    transaction_date date NOT NULL,
    acronym_transaction_type varchar(1) NOT NULL,
    amount numeric(10,2) NOT NULL,
    description varchar(100),
    id_payment_type int NOT NULL,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (acronym_transaction_type) REFERENCES transaction_type (acronym),
    FOREIGN KEY (id_payment_type) REFERENCES payment_type (id)
);
