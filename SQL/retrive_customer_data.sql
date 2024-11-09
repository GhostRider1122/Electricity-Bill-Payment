-- retrieve the Customer details whose name ends with 'a'
SELECT 
  consumer_id AS CustomerID,
  customer_name AS CustomerName,
  email AS Email
  
FROM
  customers
WHERE
  customer_name LIKE '%a'
ORDER BY
  customer_name DESC;