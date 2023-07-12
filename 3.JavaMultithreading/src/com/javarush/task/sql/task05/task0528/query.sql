-- Write your code here:
select distinct publisher.name
from book
         left join author on author.id = book.author_id
         left join publisher on publisher.id = book.publisher_id
where author.full_name = 'Mark Twain';