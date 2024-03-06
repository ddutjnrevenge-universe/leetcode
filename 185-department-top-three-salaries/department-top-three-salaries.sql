# Write your MySQL query statement below
select d.name as Department, e.name as Employee, e.salary as Salary
from (select *, dense_rank() over (partition by departmentID order by salary desc) as 'rank'
from Employee) e
JOIN Department d ON e.departmentId = d.id
WHERE 
    e.rank <= 3;