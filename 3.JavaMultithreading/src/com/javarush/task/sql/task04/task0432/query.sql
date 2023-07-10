-- Write your code here:
select monthname(date), count(monthname(date))
from event
where status = 'FAILED'