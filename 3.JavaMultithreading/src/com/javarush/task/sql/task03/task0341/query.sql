-- Write your code here:
select *
from films
where title like (
    select title
    where title like '%The' between 'r%'
    )
limit 1