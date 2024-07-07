-- Write your PostgreSQL query statement below
select date_id, make_name, COUNT(DISTINCT lead_id) AS unique_leads, COUNT(DISTINCT partner_id) AS unique_partners
from DailySales
group by date_id, make_name
order by date_id, make_name