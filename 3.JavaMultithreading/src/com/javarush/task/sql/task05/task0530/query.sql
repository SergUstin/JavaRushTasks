-- Write your code here:
select name,
       year(discovery_date) as d_year,
       MONTHNAME(discovery_date) as d_month,
       DAYNAME(discovery_date) as d_day
from space.object