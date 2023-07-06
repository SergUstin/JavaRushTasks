-- Write your code here:
select full_name
from film_directors left join (
    select title, director_id
    from films
    where genre = 'Camedy'
) f on film_directors.id = f.director_id