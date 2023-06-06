-- Write your code here:
select id, salary, department, name
from employee
where salary < 5000 AND department = 'dev';