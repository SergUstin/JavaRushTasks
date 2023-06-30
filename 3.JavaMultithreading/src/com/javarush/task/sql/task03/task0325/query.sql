-- Write your code here:
select c.zop_code,
       o.order_id
from customers c left join orders o on c.customer_id = o.customer_id
where o.shipped_date is not null and o.store_id = 27