-- Write your code here:
select prod_year, COUNT(*)
from cars
group by prod_year;