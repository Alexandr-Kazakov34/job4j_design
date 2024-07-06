create table humans(
	id serial primary key,
    name text,
    address text);
create table goods(
	id serial primary key,
    name text
   );
create table ozon(
	id serial primary key,
    address text
   );
create table orders(
	id serial primary key,
    human_id int references humans(id),
	good_id int references goods(id),
	ozon_id int references ozon(id)
   );
insert into humans (name) values ('Petr');
insert into humans (name) values ('Alex');
insert into humans (name) values ('Masha');
insert into humans (name) values ('Kate');
insert into humans (name) values ('Ian');
insert into goods (name) values ('Wheel');
insert into goods (name) values ('Apple');
insert into goods (name) values ('Beer');
insert into goods (name) values ('Constructor');
insert into goods (name) values ('Toy');
insert into ozon (address) values ('Poluxina 1');
insert into ozon (address) values ('Poluxina 2');
insert into ozon (address) values ('Pavlemko 5');
insert into ozon (address) values ('Pavlemko 30');
insert into ozon (address) values ('Shumskogo 5');
insert into orders (human_id, good_id, ozon_id) values (1,1,1);
insert into orders (human_id, good_id, ozon_id) values (1,2,1);
insert into orders (human_id, good_id, ozon_id) values (1,3,1);
insert into orders (human_id, good_id, ozon_id) values (1,4,2);
insert into orders (human_id, good_id, ozon_id) values (1,5,2);
insert into orders (human_id, good_id, ozon_id) values (2,1,3);
insert into orders (human_id, good_id, ozon_id) values (2,2,3);
insert into orders (human_id, good_id, ozon_id) values (2,3,4);
insert into orders (human_id, good_id, ozon_id) values (2,4,4);
insert into orders (human_id, good_id, ozon_id) values (2,5,5);
insert into orders (human_id, good_id, ozon_id) values (3,1,5);
insert into orders (human_id, good_id, ozon_id) values (3,2,1);
insert into orders (human_id, good_id, ozon_id) values (3,3,1);
insert into orders (human_id, good_id, ozon_id) values (4,4,2);
insert into orders (human_id, good_id, ozon_id) values (4,5,3);
insert into orders (human_id, good_id, ozon_id) values (5,1,5);
insert into orders (human_id, good_id, ozon_id) values (1,1,1);
insert into orders (human_id, good_id, ozon_id) values (1,2,1);
insert into orders (human_id, good_id, ozon_id) values (1,3,1);
insert into orders (human_id, good_id, ozon_id) values (1,4,2);
insert into orders (human_id, good_id, ozon_id) values (1,5,2);
insert into orders (human_id, good_id, ozon_id) values (2,1,3);
insert into orders (human_id, good_id, ozon_id) values (2,2,3);
insert into orders (human_id, good_id, ozon_id) values (2,3,4);
insert into orders (human_id, good_id, ozon_id) values (2,4,4);

create view people_with_2_or_more_goods as
select h.name as human, count(g.name), g.name as good, oz.address as ozon
from humans h
join orders o on h.id = o.human_id
join goods g on g.id = o.good_id
join ozon oz on oz.id = o.ozon_id
group by (h.name, g.name, oz.address)
having count(g.name) >= 2;

select*from people_with_2_or_more_goods;