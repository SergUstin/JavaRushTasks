-- Write your code here:
select gym.location as gym_location,
       person.location as person_location
from gyms gym, customer person
where person.location != 'London'
group by gym.location, person.location