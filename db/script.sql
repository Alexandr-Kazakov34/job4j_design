create table cats (
id serial primary key,
name varchar(255),
age int,
sex boolean,
area text
);
insert into cats(name, age, sex, area)values('Tom', 5, true, 'Russia');
select * from cats;
update cats set name = 'Som';
select * from cats;
delete from cats;
select * from cats;