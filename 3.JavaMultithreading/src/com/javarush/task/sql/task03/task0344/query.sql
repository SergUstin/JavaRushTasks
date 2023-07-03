-- Write your code here:
select title
from films left join (select last_name
                      from film_directors
                      where last_name like ('%Spielberg%')
                     ) director on director.id = films.director_id