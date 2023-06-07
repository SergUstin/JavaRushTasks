-- Write your code here:
select id, identifier, description
from parts
order by identifier ASC, required DESC, description DESC
limit 7;