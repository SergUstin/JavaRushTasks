-- Write your code here:
select city
from cities
order by char_length(city) DESC
limit 3