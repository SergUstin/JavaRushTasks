-- Write your code here:
select prod_year, count(*)
from cars
where name = 'Blue'
group by prod_year;