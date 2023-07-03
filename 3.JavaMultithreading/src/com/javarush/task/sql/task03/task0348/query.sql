-- Write your code here:
with grossed_total as (select sum(grossed) as total
                       from films),
     average_grossed as (select avg(grossed_total))

