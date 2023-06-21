-- Write your code here:
select distinct name,
                case
                    when prod_year = 2020 then 'new'
                    when prod_year = 2021 then 'newer'
                    when prod_year = 2022 then 'even newer'
                    end
from cars