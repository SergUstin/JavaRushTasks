-- Write your code here:
select c.customer_id,
       o.customer_id
from customers c left join orders o on c.customer_id = o.customer_id
where o.shipped_date is null