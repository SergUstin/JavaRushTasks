-- Write your code here:
select if(positon = 'manager', if(salary > 10000, 'good', 'bad'), if(salary > 5000, 'good', 'bad'))
from employee
where city = 'London';

-- if ((position = 'manager' and salary > 10000) or (position != 'manager' and salary > 5000), 'good', 'bad')