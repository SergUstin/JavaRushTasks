-- Write your code here:
select date_of_birth as year_of_birth, count(*)
from employee
where position = 'developer'