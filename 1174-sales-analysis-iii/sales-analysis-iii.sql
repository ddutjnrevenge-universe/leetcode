-- Write your PostgreSQL query statement below
select distinct p.product_id, p.product_name
from Product p
left join Sales s on s.product_id = p.product_id
where s.sale_date between '2019-01-01' and '2019-03-31' 
and p.product_id not in (select distinct product_id from Sales
where sale_date < '2019-01-01' or sale_date > '2019-03-31')
