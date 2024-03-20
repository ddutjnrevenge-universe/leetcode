SELECT 
    ROUND(SUM(logged_back) / COUNT(DISTINCT player_id), 2) AS fraction
FROM (
    SELECT 
        player_id,
        CASE WHEN 
            LEAD(event_date) OVER (PARTITION BY player_id ORDER BY event_date) = DATE_ADD(MIN(event_date) OVER (PARTITION BY player_id), INTERVAL 1 DAY)
        THEN 1 ELSE 0 END AS logged_back
    FROM 
        Activity
) AS subquery;
