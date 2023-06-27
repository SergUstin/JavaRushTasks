-- Write your code here:
select department, position, count(*) as total
from employee
where postion = 'frontend developer'
group by department, position
having total > 1