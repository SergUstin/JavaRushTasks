-- Write your code here:
select book.publication_year,
       book.isbn,
       book.title,
       author.full_name as author,
       publisher.name as publisher
from book
         left join author on author.id = book.author_id
         left join publisher on book.publisher_id = publisher.id;