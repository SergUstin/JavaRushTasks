-- Write your code here:
select author.full_name as full_name, book.title
from author, book
where title > 1
order by title;