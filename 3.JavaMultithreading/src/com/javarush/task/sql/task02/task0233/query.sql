-- Write your code here:
select YEAR(date_of_birth), count(*)
from employee
group by YEAR(date_of_birth);