-- Write your code here:
select case is_full_time
           when 'no' then 'заочник'
           when 'yes' then 'стационар'
           end
from students