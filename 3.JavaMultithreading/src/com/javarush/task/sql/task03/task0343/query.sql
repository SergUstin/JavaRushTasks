-- Write your code here:
select full_name
from film_directors left join (
    select title
    from films
    where genre = 'Camedy'
) f on film_directors.id = films.director_id