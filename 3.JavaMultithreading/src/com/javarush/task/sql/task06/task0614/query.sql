-- Write your code here:
update employee
set salary = salary + 1000
where employee.id in (select employee.id
                      from task
                      where exp_date > '2022-10-01');

