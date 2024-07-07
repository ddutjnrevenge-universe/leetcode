-- Write your PostgreSQL query statement below
UPDATE Salary
set sex = CASE
    when sex ='f' then 'm'
    else 'f'
    end;