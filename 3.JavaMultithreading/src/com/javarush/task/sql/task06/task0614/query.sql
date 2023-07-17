-- Write your code here:
update employee,
    (select count(*)
     from task
     where exp_date < '2022-10-01' and просроченные_задачи = 'нет') as good_emps
set
    salary = salary + 1000
where employee.id = task.employee_id