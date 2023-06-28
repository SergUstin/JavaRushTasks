-- Write your code here:
select retailers.name as ret_name,
       sup.name as sup_name,
       sup.country as sup_country
from top_retailers retailers, suppliers sup