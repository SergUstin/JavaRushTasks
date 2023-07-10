-- Write your code here:
select name, ceil(inventory = inventory + lego_set.inventory * 1 / 100) as with_spare_parts
from lego_set;