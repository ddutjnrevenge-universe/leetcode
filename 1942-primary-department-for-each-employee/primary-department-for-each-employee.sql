SELECT employee_id, 
       CASE 
           WHEN COUNT(*) = 1 THEN department_id
           WHEN COUNT(*) > 1 AND COUNT(CASE WHEN primary_flag = 'Y' THEN 1 END) > 0 THEN MAX(CASE WHEN primary_flag = 'Y' THEN department_id ELSE NULL END)
           ELSE NULL 
       END AS department_id
FROM Employee
GROUP BY employee_id
HAVING COUNT(*) = 1 OR COUNT(CASE WHEN primary_flag = 'Y' THEN 1 END) > 0;
