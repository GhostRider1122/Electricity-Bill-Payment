SELECT
  c.consumer_id AS Consumer_ID,
  c.customer_name AS Customer_Name
FROM
  customers c 
WHERE
  c.consumer_id IN
  (
    SELECT b.consumer_id
    FROM monthly_bill b 
    WHERE b.bill_month = 'June' AND b.bill_status='Unpaid'
  );