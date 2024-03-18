WITH FirstOrders AS (
    SELECT customer_id, MIN(order_date) as FirstOrderDate
    FROM Delivery
    GROUP BY customer_id
),
ImmediateFirstOrders AS (
    SELECT d.customer_id
    FROM Delivery d
    JOIN FirstOrders fo ON d.customer_id = fo.customer_id AND d.order_date = fo.FirstOrderDate
    WHERE d.order_date = d.customer_pref_delivery_date
)
SELECT 
    CASE 
        WHEN (SELECT COUNT(*) FROM FirstOrders) = 0 THEN 0  -- Handle division by zero
        ELSE ROUND((SELECT COUNT(*) FROM ImmediateFirstOrders) * 100.0 / (SELECT COUNT(*) FROM FirstOrders), 2)
    END AS immediate_percentage;
