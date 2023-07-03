-- Write your code here:
select *
from films join (
    select year_born
    from film_directors
    where year_born > 1940
) director on director.id = films.director_id
where genre = 'sci-fi'