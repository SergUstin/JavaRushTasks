-- Write your code here:
select ip_from, ip_to, country_name
from ip2country
order by ip_to DESC
limit 50
OFFSET 74;