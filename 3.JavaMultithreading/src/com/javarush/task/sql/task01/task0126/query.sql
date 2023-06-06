-- Write your code here:
select brand, model, quantity, booked_quantity
from car
where model IN (renault, opel, seat, skoda)
   OR quantity between booked_quantity < 10;