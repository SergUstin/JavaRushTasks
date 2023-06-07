-- Write your code here:
select distinct country_name
from ip2country
where country_name NOT LIKE ' ';