--Inserts dummy values in the customers table
INSERT INTO customers (consumer_id, customer_name, email, mobile_number, user_id, password, confirm_password, status)
VALUES
  (1234567890123, 'John Doe', 'johndoe@example.com', '1234567890', 'johndoe123', 'password123', 'password123', 'Active'),
  (2345678901234, 'Jane Smith', 'janesmith@example.com', '9876543210', 'janesmith456', 'password456', 'password456', 'Active'),
  (3456789012345, 'Michael Johnson', 'michaeljohnson@example.com', '1112223333', 'mjohnson789', 'password789', 'password789', 'Inactive'),
  (4567890123456, 'Emily Brown', 'emilybrown@example.com', '4445556666', 'ebrown101', 'password101', 'password101', 'Active'),
  (5678901234567, 'David Lee', 'davidlee@example.com', '7778889999', 'dlee111', 'password111', 'password111', 'Inactive');