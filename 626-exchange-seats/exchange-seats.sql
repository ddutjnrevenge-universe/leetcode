SELECT id,
    CASE 
        WHEN id % 2 = 1 AND id = (SELECT MAX(id) FROM Seat) THEN student
        WHEN id % 2 = 1 THEN next_student
        ELSE prev_student
    END AS student
FROM (
    SELECT 
        s1.id,
        s1.student,
        s2.student AS next_student,
        LAG(s1.student) OVER (ORDER BY s1.id) AS prev_student
    FROM 
        Seat s1
    LEFT JOIN 
        Seat s2 ON s1.id + 1 = s2.id
) AS temp
ORDER BY id;
