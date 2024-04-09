# Write your MySQL query statement below
select name as results
from Users 
where user_id = (select user_id from(
    select m.user_id, name, count(*) as mv_rating from MovieRating m
    left join Users u on u.user_id = m.user_id
    group by m.user_id
    order by mv_rating desc, name asc
    limit 1) 
    as subquery)
union all
select title
from Movies 
WHERE movie_id =  (select movie_id from (
    select m.movie_id, title, avg(rating) as avg_rating from MovieRating mv
    left join Movies m on mv.movie_id=m.movie_id
    where created_at>'2020-01-31' and created_at<'2020-03-01'
    group by m.movie_id
    order by avg_rating desc, title asc
    limit 1) 
    as subquery)
