-- Write your code here:
select *
from films
where title in (
    select title
    from films
    where title like 'The%r'
    limit 1
    )