# Write your MySQL query statement below
# Write your MySQL query statement below
with filteredTrips as (
    select t.request_at, t.status
    from Trips t
    join Users c on t.client_id=c.users_id
    join Users d on t.driver_id=d.users_id
    where c.banned = 'No' and d.banned = 'No'
),
tripStats as (
    select 
        request_at as Day,
        count(*) as totalRequests,
        sum(case when status in ('cancelled_by_driver', 'cancelled_by_client') then 1 else 0 end) as cancelledRequests
    from filteredTrips
    group by request_at
),
allDays as (select distinct request_at as Day from Trips 
            where request_at between '2013-10-01' and '2013-10-03')
select a.Day, round(cancelledRequests/totalRequests,2) as 'Cancellation Rate'
from allDays a
inner join tripStats ts on a.Day  = ts.Day
order by Day