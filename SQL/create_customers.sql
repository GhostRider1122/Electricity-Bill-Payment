--Table for storing customer data
CREATE TABLE customers (
    consumer_id BIGINT(13) PRIMARY KEY,
    customer_name VARCHAR(50),
    email VARCHAR(100),
    mobile_number BIGINT(10),
    user_id VARCHAR(20) CHECK (LENGTH(user_id) BETWEEN 5 AND 20),
    password VARCHAR(30),
    confirm_password VARCHAR(30),
    status VARCHAR(8) CHECK (status IN ('Active', 'Inactive'))
);

  
  
