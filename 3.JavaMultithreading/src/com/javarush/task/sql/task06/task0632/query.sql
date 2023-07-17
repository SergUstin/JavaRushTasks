-- Write your code here:
alter table event add foreign key (user_id)
references user(id)
on UPDATE cascade
on delete set null