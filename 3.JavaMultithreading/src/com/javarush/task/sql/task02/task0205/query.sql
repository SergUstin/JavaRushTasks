-- Write your code here:
select id, if(salary > 1000, 'yes', 'no')
from employee
where id < 5;