# Write your MySQL query statement below
select d.name as Department, e.name as Employee, e.salary as Salary
from Employee e
join Department d on e.departmentId = d.id
JOIN 
    (SELECT departmentId, MAX(salary) AS max_salary
     FROM Employee
     GROUP BY departmentId) AS max_salaries
ON 
    e.departmentId = max_salaries.departmentId
    AND e.salary = max_salaries.max_salary;