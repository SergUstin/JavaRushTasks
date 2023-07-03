-- Write your code here:
select last_name
from film_directors left join (
    select grossed
    from films
    where grossed > 100
) film on film_directors.id = film.director_id
where country = 'UK'