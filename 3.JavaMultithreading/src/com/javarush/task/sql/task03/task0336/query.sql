-- Write your code here:
select authors.year_born as author_country
from authors
where books.year_born <= books.date_released