create table authors(
id serial primary key,
name varchar(255) not null,
birth_date int
);
create table books(
id serial primary key,
title varchar(255) not null,
authors_id int references authors(id)
);
insert into authors(name) values('Lev Tolstoy');
update authors set birth_date = 1828;
insert into books(title, authors_id)values('War and Piace',1);
select*from books;