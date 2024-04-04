# Write your MySQL query statement below
select p.product_name, sum(o.unit) as unit
from Products p
left join Orders o on o.product_id=p.product_id
where MONTH(o.order_date) = 2 AND YEAR(o.order_date) = 2020
group by p.product_id
having unit >= 100 