-- Write your code here:
select department, position, count(*) as total
from employee
where postion = 'backend developer'
group by department, position
having total = 1