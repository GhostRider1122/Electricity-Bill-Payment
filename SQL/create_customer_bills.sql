-- Script: create_customer_bills.sql
CREATE TABLE customer_bills (
    consumer_id     BIGINT(13) PRIMARY KEY,
    customer_name   VARCHAR(50),
    address         VARCHAR(100),
    city            VARCHAR(50),
    bill_amount     numeric(10, 2)
);