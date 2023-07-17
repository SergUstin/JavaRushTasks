-- Write your code here:
insert into sale_addresses (street, city, state, zip_code, country)
select customers.street,
       customers.city,
       customers.state,
       customers.zip_code,
       customers.country
from customers
where customers.country != 'Testostan';