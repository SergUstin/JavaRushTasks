-- Write your code here:
select department as department_name, count(*) as caunt
from employee
where position = 'frontend developer' or 'backend developer';