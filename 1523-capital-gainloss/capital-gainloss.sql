-- Write your PostgreSQL query statement below
-- with CTE_Stocks as (
--     select stock_name, operation, price,
--         ROW_NUMBER() OVER (PARTITION BY stock_name, operation ORDER BY operation_day) AS rn
--     from Stocks
-- )
-- select b.stock_name,
--     SUM(s.price - b.price) AS capital_gain_loss
-- from CTE_Stocks b
-- join CTE_Stocks s
-- on b.stock_name = s.stock_name
-- and b.rn = s.rn
-- and b.operation = 'Buy'
-- and s.operation = 'Sell'
-- group by b.stock_name;
with b as (
    select stock_name, sum(price) as buy 
    from Stocks 
    where operation='Buy' 
    group by stock_name),
s as (
    select stock_name, sum(price) as sell 
    from Stocks 
    where operation='Sell' 
    group by stock_name)
select b.stock_name, sell-buy as capital_gain_loss 
from b join s on b.stock_name=s.stock_name