-- Write your code here:
select curdate(),
       date_add(now(), interval 3 day),
       date_sub(now(), interval 3 day)