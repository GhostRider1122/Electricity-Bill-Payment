SELECT 
  city AS City, 
  ROUND(AVG(bill_amount), 2) AS Avg_Bill
FROM 
  customer_bills
GROUP BY 
  city 
ORDER BY 
  Avg_Bill DESC;