# Write your MySQL query statement below
select c.customer_id
from Customer c
left join Product p on c.product_key=p.product_key
group by c.customer_id
having count(distinct c.product_key) = (select count(*) from Product)