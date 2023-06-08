-- Write your code here:
select brand, model, booked_quantity
from car
where model NOT LIKE '%ea%';