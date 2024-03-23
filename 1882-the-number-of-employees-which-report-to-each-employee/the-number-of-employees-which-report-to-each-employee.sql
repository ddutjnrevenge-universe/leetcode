# Write your MySQL query statement below
select e1.employee_id, e1.name, count(e2.reports_to) as reports_count, round(avg(e2.age),0) as average_age
from Employees e1
left join Employees e2 on e1.employee_id = e2.reports_to
group by employee_id
having reports_count !=0
order by employee_id