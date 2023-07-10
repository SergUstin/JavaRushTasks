-- Write your code here:
select concat(id, ', ', name) as full_name
from lego_set
order by length(full_name);