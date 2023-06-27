-- Write your code here:
select gym.location as gym_location,
       visitor.name as visitor_name,
       visitor.sex as visitor_sex
from gyms gym, customers visitor