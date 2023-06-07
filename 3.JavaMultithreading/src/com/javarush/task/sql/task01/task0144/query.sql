-- Write your code here:
select description
from parts
order by required DESC, identifier DESC, description DESC
limit 50
offset 23;