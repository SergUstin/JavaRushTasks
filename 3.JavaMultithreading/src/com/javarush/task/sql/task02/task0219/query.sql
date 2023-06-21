-- Write your code here:
select case euro
           when null then 'good'
           else 'bad'
           end
from cars