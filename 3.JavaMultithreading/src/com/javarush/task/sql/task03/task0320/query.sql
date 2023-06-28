-- Write your code here:
select retailer.ret_name,
       retailer.ret_revenue,
       supplier.sup_name,
       supplier.sup_revenue
from top_retailers retailer join suppliers supplier
    on retailer.ret_revenue = supplier.sup_revenue
where supplier.sup_revenue > 50;