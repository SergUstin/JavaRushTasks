-- Write your code here:
select *
from event
where datediff(curdate(), date_time) < 20