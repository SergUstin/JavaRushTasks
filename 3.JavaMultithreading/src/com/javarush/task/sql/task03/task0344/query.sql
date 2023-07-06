-- Write your code here:
select title
from films left join (select last_name, id
                      from film_directors
                      where last_name = 'Spielberg'
                     ) director on director.id = films.director_id