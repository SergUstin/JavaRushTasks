-- Write your code here:
select *
from parts
where description IS NULL AND required IS true;