-- Write your code here:
select top_retailers.rank as company_rank,
       top_retailers.name as company_name,
       company_name.annual_revenue_billions as supplier_revenue
from top_retailers, company_name
where suppliers.annual_revenue_billions > 25