-- Write your code here:
select name, sum(price)
from cars
group by name