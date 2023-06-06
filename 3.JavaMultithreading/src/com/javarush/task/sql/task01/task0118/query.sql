-- Write your code here:
select department, salary, name
from employee
where salary < 1000 AND NOT salary >= 5000;