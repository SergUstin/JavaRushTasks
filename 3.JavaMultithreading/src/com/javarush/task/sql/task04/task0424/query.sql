-- Write your code here:
select name, position
from employee
where day(date_of_birth) between 1 and 200