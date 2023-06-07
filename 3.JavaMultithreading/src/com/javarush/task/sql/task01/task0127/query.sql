-- Write your code here:
select *
from car
where model NOT LIKE '%a' AND (quantity - booked_quantity) between 5 and 500;