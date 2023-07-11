-- Write your code here:
select dayname(date), count(*)
from event
where type = 'REGISTRATION'
group by dayname(date)
order by count(*) DESC
limit 1