# Write your MySQL query statement below
select distinct id, sum(re) as num
from
(select requester_id as id, count(requester_id) as re
from RequestAccepted
group by requester_id
union all
select accepter_id as id, count(accepter_id) 
from RequestAccepted
group by accepter_id) as sub
group by id
order by num desc
limit 1