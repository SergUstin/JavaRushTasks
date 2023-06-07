-- Write your code here:
select *
from parts
where (id between 7 AND 23) AND identifier IS NULL
limit 2;