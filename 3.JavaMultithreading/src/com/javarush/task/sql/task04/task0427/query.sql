-- Write your code here:
select *
from event
where datediff(date_time, curdate()) < 20