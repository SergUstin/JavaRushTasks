-- Write your code here:
select count(*)
from employee
group by date_of_birth;