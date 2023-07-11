-- Write your code here:
select monthname(date), count(*)
from event
where status = 'FAILED' or status = 'FAILED'
group by monthname(date)
order by count(*) DESC
limit 1