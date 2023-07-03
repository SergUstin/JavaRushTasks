-- Write your code here:
select *
from film_directors right join (
    select title
    from films
    where title > 1990
) film on film_directors.id = film.director_id
where country = 'USA'
limit 5