-- Write your PostgreSQL query statement below
select u.user_id as buyer_id, u.join_date, count(o.order_id) as orders_in_2019
from Users u
left join Orders o on o.buyer_id = u.user_id and o.order_date between '2019-01-01' and '2019-12-31'
group by u.user_id, u.join_date