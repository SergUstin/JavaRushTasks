-- Write your code here:
select r.ret_name,
       r.ret_location,
       s.sup_name,
       s.sup_country
from top_retailers r join suppliers s on r.ret_location = s.sup_country