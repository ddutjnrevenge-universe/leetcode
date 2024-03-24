# Write your MySQL query statement below
select max(single) as num
from (select num as single from MyNumbers group by num having count(num)<=1) as subquery
