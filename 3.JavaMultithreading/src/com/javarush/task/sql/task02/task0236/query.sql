-- Write your code here:
select department, position, count(*)
from employee
group by department, position