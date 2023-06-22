-- Write your code here:
select name, count(*)
from cars
group by name;