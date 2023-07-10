-- Write your code here:
select year(date), month(date), day(date), year(sum(total)),
       month(sum(total)), day(sum(total))