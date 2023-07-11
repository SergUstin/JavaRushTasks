-- Write your code here:
select concat(city, '-', char_length(city))
from cities
where char_length(city)
limit 3