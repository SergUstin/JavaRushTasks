-- Write your code here:
select *
from parts
where description IS NOT NULL OR identifier IS NULL;