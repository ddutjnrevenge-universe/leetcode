with consecutive as ( 
    select *, row_number() over (order by id) - id as grp
    from Stadium
    where people >= 100
),
filtered as (
    select * , count(*) over (partition by grp) as group_size
    from consecutive
)
select id, visit_date, people
from filtered
where group_size >= 3
order by visit_date