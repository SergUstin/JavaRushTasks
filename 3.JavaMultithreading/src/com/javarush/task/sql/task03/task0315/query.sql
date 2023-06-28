-- Write your code here:
select ret.hq_location as ret_location,
       sup.annual_revenue_billions as sup_revenue
from top_retailers ret, suppliers sup
where ret.hq_location != 'USA';