-- Creating the Monthly Bill table for June
CREATE TABLE monthly_bill (
    bill_id       INT(5) PRIMARY KEY,
    consumer_id   BIGINT(13),
    bill_month    VARCHAR(10),
    bill_amount   DECIMAL(10, 2),
    bill_status   VARCHAR(10) CHECK (bill_status IN ('Paid', 'Unpaid')),
    due_date      DATE,
    FOREIGN KEY (consumer_id) REFERENCES customers(consumer_id)
);