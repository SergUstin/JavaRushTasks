-- Write your code here:
select country_code, ip_from, ip_to
from ip2country
where country_code = 'DE'
limit 5
offset 3;