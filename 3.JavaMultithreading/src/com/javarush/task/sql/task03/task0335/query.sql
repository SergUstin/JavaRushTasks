-- Write your code here:
select author.country as author_country,
       count(book.book_id) as book_count
from authors author join books book on author.id = book.author_id
where book.genre = 'novel'
group by author.country
having count(book.book_id) > 2