-- Write your code here:
select author.full_name as full_name,
       count(distinct publisher.name) as publishers
from book
         left join author on author.id = book.author_id
         left join publisher on publisher.id = book.publisher_id
group by author.id;


