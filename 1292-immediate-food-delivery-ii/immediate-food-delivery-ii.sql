SELECT 
    CASE 
        WHEN fo.total_first_orders = 0 THEN 0  -- Handle division by zero
        ELSE ROUND((IFNULL(immediate_first_orders.immediate_count, 0) / fo.total_first_orders) * 100, 2)
    END AS immediate_percentage
FROM (
    SELECT 
        COUNT(*) AS total_first_orders
    FROM (
        SELECT 
            customer_id, 
            MIN(order_date) AS FirstOrderDate
        FROM 
            Delivery
        GROUP BY 
            customer_id
    ) AS first_orders
) AS fo
LEFT JOIN (
    SELECT 
        COUNT(*) AS immediate_count
    FROM 
        Delivery d
    JOIN (
        SELECT 
            customer_id, 
            MIN(order_date) AS FirstOrderDate
        FROM 
            Delivery
        GROUP BY 
            customer_id
    ) AS first_orders ON d.customer_id = first_orders.customer_id AND d.order_date = first_orders.FirstOrderDate
    WHERE 
        d.order_date = d.customer_pref_delivery_date
) AS immediate_first_orders ON 1=1;
