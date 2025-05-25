SELECT p.id, p.client_id, p.start_date, p.finish_date, 
       DATEDIFF(MONTH, p.start_date, p.finish_date) AS duration_months,
       SUM(w.salary) AS total_salary,
       DATEDIFF(MONTH, p.start_date, p.finish_date) * SUM(w.salary) AS project_cost
FROM project p
JOIN project_worker pw ON p.id = pw.project_id
JOIN worker w ON pw.worker_id = w.id
GROUP BY p.id, p.client_id, p.start_date, p.finish_date
ORDER BY project_cost DESC;
