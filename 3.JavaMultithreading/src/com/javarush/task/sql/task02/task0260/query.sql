-- Write your code here:
select rating, name, count(*)
from employee
group by rating, name
having rating > 2
