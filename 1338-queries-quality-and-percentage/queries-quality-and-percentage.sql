# Write your MySQL query statement below
select query_name, round(avg(rating/position),2) as quality, 
round((SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END) / count(*)) * 100, 2) AS poor_query_percentage
from Queries
where query_name is not null
group by query_name
