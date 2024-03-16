# Write your MySQL query statement below
select distinct p.product_id,coalesce(round(sum(price*units)/sum(units),2),0) as average_price
from Prices p
left join UnitsSold u on p.product_id = u.product_id
AND u.purchase_date BETWEEN p.start_date AND p.end_date
group by p.product_id