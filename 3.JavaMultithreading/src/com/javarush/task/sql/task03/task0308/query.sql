-- Write your code here:
select g.location, person.name, person.email, person.telephone
from gyms g, customer person
where customer.name = 'Hulk'