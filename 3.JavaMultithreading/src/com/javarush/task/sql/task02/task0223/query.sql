-- Write your code here:
select department, count(*)
from employee
group by department;