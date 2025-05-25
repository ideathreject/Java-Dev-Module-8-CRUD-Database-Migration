SELECT 
    'YOUNGEST' AS TYPE,
    w.name,
    w.birthday
FROM worker w
WHERE w.birthday = (
    SELECT MIN(birthday) 
    FROM worker
)
UNION
SELECT 
    'OLDEST' AS TYPE,
    w.name,
    w.birthday
FROM worker w
WHERE w.birthday = (
    SELECT MAX(birthday) 
    FROM worker
);