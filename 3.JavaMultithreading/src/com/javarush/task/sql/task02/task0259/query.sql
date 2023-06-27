-- Write your code here:
select position, group_concat(name)
from employee
where position like '$developer$'