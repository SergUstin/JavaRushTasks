-- Write your code here:
select *
from gyms, customers
where gyms.location = 'London' and customers.location = 'London';