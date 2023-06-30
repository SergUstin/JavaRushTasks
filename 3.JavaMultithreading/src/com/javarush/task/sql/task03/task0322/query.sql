-- Write your code here:
select c.customer_id,
       c.email,
       o.order_id,
       o.order_status
from customers c join orders o on c.customer_id = o.customer_id
where o.order_status like '%PAID%' or o.order_status like '%PROCESSING%';