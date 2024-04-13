SELECT 
    categories.salary_category as category,
    IFNULL(t.number_of_accounts, 0) AS accounts_count
FROM 
    (SELECT 'Low Salary' AS salary_category
     UNION ALL SELECT 'Average Salary'
     UNION ALL SELECT 'High Salary') AS categories
LEFT JOIN 
    (SELECT 
        CASE
            WHEN income < 20000 THEN 'Low Salary'
            WHEN income BETWEEN 20000 AND 50000 THEN 'Average Salary'
            ELSE 'High Salary'
        END AS salary_category,
        COUNT(account_id) AS number_of_accounts
    FROM Accounts
    GROUP BY salary_category) AS t
ON categories.salary_category = t.salary_category;
