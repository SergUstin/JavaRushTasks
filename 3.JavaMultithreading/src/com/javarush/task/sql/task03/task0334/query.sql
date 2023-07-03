-- Write your code here:
select a.last_name as author,
       a.country as author_country,
       b.genre as book_genre
from authors a left join books b on a.id = b.author_id
where b.genre = 'fantasy'
group by a.last_name, a.country, b.genre
order by a.country ASC
limit 5