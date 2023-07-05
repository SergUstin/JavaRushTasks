-- Write your code here:
select *
from film_directors
where full_name like (
    select concat(first_name, ' ', last_name)
    having concat(first_name, ' ', last_name) = 1
)