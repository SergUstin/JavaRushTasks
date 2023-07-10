-- Write your code here:
select name, released, inventory
from lego_set
group by released
order by released;