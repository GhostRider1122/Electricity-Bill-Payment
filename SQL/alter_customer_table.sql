-- Add the new columns to the existing customer table
ALTER TABLE customer
ADD (
    title VARCHAR(10),    -- For titles like 'Mr.', 'Mrs.', etc.
    bill_number NUMBER(5)        -- Last 5 digits of the consumer bill
);