# Write your MySQL query statement below
select project_id, round(avg(experience_years),2) as average_years
from Project p
left join Employee e on e.employee_id = p.employee_id
group by project_id