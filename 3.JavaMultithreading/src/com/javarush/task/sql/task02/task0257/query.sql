-- Write your code here:
select name, sum(price), avg(price)
from cars
group by name
having avg(price) > 100000