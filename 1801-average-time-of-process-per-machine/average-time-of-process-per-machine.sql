SELECT 
    machine_id,
    ROUND(SUM(end_time - start_time) / COUNT(process_id), 3) AS processing_time
FROM (
    SELECT 
        machine_id,
        process_id,
        MIN(CASE WHEN activity_type = 'start' THEN timestamp END) AS start_time,
        MAX(CASE WHEN activity_type = 'end' THEN timestamp END) AS end_time
    FROM 
        Activity
    GROUP BY 
        machine_id, process_id
) AS subquery
GROUP BY 
    machine_id;
