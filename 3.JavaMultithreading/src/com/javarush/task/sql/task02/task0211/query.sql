-- Write your code here:
select age, if(age <= 12, 'child', if(age >= 20, 'adult', 'teenager'))
from customers
limit 5;