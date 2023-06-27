-- Write your code here:
select g.id as g_id,
       g.name as g_name,
       c.name as c_name,
       c.email as c_email
from gyms g, customers c;
