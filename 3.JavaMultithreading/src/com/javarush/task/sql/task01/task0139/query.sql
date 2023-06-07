-- Write your code here:
select country_code, ip_from, ip_to
from ip2country
order by ip_from ASC
limit 17;