-- Write your code here:
select dayname(date), type = 'REGISTRATION'
from event
where dayname(date) > 5