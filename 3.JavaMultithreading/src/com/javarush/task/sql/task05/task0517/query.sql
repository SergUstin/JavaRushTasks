-- Write your code here:
select released, count(released)
from lego_set
group by released;