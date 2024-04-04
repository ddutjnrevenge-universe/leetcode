# Write your MySQL query statement below
select x,y,z,
case when z between abs(x-y)+1 and (x+y)-1 then 'Yes'
when y between abs(x-z)+1 and (x+z)-1 then 'Yes'
when x between abs(z-y)+1 and (z+y)-1 then 'Yes'
else 'No'
end as triangle 
from Triangle