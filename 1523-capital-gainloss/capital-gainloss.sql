-- Write your PostgreSQL query statement below
with CTE_Stocks as (
    select stock_name, operation, price,
        ROW_NUMBER() OVER (PARTITION BY stock_name, operation ORDER BY operation_day) AS rn
    from Stocks
)
select b.stock_name,
    SUM(s.price - b.price) AS capital_gain_loss
from CTE_Stocks b
join CTE_Stocks s
on b.stock_name = s.stock_name
and b.rn = s.rn
and b.operation = 'Buy'
and s.operation = 'Sell'
group by b.stock_name;
