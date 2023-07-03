-- Write your code here:
select аuth.last_name as author,
       book.genre as book_genre,
       book.date_released
from authors аuth right join books book on auth.author_id = book.author_id
where book.date_released < 1900
group by book.genre, book.date_released