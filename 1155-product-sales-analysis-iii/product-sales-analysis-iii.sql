SELECT 
    s.product_id, s.year AS first_year, s.quantity, s.price
FROM Sales s
JOIN Product p ON s.product_id = p.product_id
WHERE (s.product_id, s.year) IN (
        SELECT product_id,MIN(year) AS first_year
        FROM Sales
        GROUP BY product_id
    );