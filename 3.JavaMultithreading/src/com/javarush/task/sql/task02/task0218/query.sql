-- Write your code here:
select case nullif(euro, 6)
           when euro > 5 then 'best'
           when euro = 5 then 'good'
           else 'bad'
           end
from cars