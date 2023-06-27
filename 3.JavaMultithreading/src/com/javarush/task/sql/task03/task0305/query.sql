-- Write your code here:
select gyms.id as g_id,
       gyms.name as g_name,
       customers.name as c_name,
       customers.email as c_email
from gyms, customers;
