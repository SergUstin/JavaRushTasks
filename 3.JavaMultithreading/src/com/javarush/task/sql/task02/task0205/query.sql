-- Write your code here:
select id, salary
from employee
where if(salary > 1000, 'yes', 'no')
limit 4;