-- Write your code here:
select *
from event
where year(curdate()) = year(date_time) and month(date_time)