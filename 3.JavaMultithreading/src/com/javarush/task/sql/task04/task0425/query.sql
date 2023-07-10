-- Write your code here:
select count(year(date_of_birth)), count(month(date_of_birth))
from employee