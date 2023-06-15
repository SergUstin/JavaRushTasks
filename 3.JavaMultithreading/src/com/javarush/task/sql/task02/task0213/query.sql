-- Write your code here:
select
    case
        when is_full_time = 1 then true
        when is_full_time = 0 then false
        else is_full_time
    end
from students