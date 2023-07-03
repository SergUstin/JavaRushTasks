-- Write your code here:
select customers.phone as cust_phone,
       orders.order_date,
       orders.total_cost,
       orders.store_id
from customers right join orders on customers.customer_id = orders.customer_id
where customers.city = 'New York' and orders.order_status = 'PROCESSING'