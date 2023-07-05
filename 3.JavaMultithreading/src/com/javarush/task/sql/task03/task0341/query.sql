-- Write your code here:
select *
from films
where title in (
    select title
    where title like '%The' between 'r%'
    )
limit 1