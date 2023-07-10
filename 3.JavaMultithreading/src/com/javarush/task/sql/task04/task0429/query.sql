-- Write your code here:
select *
from event
where date_time between date_sub(curdate(), interval 2 week) and curdate();