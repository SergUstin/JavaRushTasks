-- Write your code here:
select year(date), month(date), day(date), sum(total)
from data
group by year(date), month(date), day(date)