-- Write your code here:
select gym.id as gym_id,
       gym.name as gym_name,
       cust.id as cust_id
from gyms gym, customers cust
where cust.id < 50