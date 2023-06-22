-- Write your code here:
select case
           when euro is null then 'good'
           else 'bad'
           end
from cars