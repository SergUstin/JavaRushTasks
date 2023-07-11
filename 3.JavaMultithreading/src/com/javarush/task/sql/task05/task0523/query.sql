-- Write your code here:
select name, ceil(inventory * 1.01) as with_spare_parts
from lego_set;