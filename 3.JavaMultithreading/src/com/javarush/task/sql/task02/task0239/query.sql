-- Write your code here:
select year(date_of_birth), month(date_of_birth)
from employee
where month(date_of_birth) in (12, 1, 2);