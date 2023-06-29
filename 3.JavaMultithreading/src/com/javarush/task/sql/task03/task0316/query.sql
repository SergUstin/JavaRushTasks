-- Write your code here:
select retailer.name as ret_name,
       retailer.hq_location as ret_locationret_location,
       supplier.name as sup_name
from top_retailers retailer, suppliers supplier
where supplier.annual_revenue_billions > 100