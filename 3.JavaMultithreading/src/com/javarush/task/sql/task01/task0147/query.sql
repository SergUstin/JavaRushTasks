-- Write your code here:
select required, identifier, description
from parts
where description IS NULL OR required is true;