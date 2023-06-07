-- Write your code here:
select id, identifier, description
from parts
order by identifier DESC, required DESC, description ASC;