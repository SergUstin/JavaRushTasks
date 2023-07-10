-- Write your code here:
select name, position
from employee
where dayname(date_of_birth) = 'Monday'