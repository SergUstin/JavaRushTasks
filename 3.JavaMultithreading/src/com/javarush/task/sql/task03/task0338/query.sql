-- Write your code here:
select *
from authors
where full_name not like (
    select first_name + ' ' + last_name
    where last_name != 'Shakespeare'
    )