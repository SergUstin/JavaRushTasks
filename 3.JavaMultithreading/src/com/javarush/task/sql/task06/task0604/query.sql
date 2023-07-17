-- Write your code here:
create table if not exists users (
    user_id int auto_increment primary key not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null
);