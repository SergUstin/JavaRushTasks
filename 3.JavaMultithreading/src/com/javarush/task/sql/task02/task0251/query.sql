-- Write your code here:
select department, position, count(*) as total
from employee
where position = 'manager'
group by department, position
having total = 1
limit 50
offset 1