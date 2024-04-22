# Write your MySQL query statement below
select id,
case
when p_id is null then "Root"
WHEN id IN (SELECT DISTINCT p_id FROM Tree) THEN 'Inner'
        ELSE 'Leaf'
    END AS Type 
from Tree