-- Write your code here:
select released, count(*)
from lego_set
group by released;