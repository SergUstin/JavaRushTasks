-- Write your code here:
select author.id as isbn, book.id as title
from author, book
where last_name like '%S';