-- Write your code here:
select author.full_name as full_name,
       if(publisher.name is not null, publisher.name, 0) as name
from book
         left join author on author.id = book.author_id
         left join publisher on publisher.id = book.publisher_id
