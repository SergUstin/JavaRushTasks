-- Write your code here:
select *
from authors
where id not in (
    select author_id
    from books
    where author_id is not null or genre = 'play'
    )