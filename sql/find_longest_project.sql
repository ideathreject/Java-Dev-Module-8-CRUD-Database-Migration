SELECT p.id, p.client_id, p.start_date, p.finish_date, 
       DATEDIFF(MONTH, p.start_date, p.finish_date) AS duration_months
FROM project p
WHERE DATEDIFF(MONTH, p.start_date, p.finish_date) = (
    SELECT MAX(DATEDIFF(MONTH, p1.start_date, p1.finish_date))
    FROM project p1
);
