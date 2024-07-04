create table type(
id serial primary key,
name text);
create table product(
id serial primary key,
name text,
type_id int references type(id),
expire_date text,
price int);
INSERT INTO type (name) VALUES ('СЫР');
INSERT INTO type (name) VALUES ('МОЛОКО');
INSERT INTO type (name) VALUES ('Мороженое');
INSERT INTO type (name) VALUES ('Хлеб');
INSERT INTO product (name, type_id, expire_date, price) VALUES ('Чеддер', 1, '2023-12-01', 500.00);
INSERT INTO product (name, type_id, expire_date, price) VALUES ('Гауда', 1, '2024-01-15', 600.00);
INSERT INTO product (name, type_id, expire_date, price) VALUES ('Моцарелла', 1, '2023-11-20', 550.00);
INSERT INTO product (name, type_id, expire_date, price) VALUES ('Цельное молоко', 2, '2024-01-05', 100.00);
INSERT INTO product (name, type_id, expire_date, price) VALUES ('Молоко пастеризованное', 2, '2023-10-30', 90.00);
INSERT INTO product (name, type_id, expire_date, price) VALUES ('Шоколадное мороженое', 3, '2024-06-15', 200.00);
INSERT INTO product (name, type_id, expire_date, price) VALUES ('Ванильное мороженое', 3, '2024-06-20', 220.00);
INSERT INTO product (name, type_id, expire_date, price) VALUES ('Пшеничный хлеб', 4, '2023-07-01', 30.00);
INSERT INTO product (name, type_id, expire_date, price) VALUES ('Ржаной хлеб', 4, '2023-07-01', 35.00);

select *from product p
join type t on p.type_id = t.id
where t.name = 'СЫР';

select * from product
where name like '%мороженое%';

select * from product
where expire_date < '2024-07-04';

select t.name, max(p.price)
from type t join product p
on t.id = p.type_id group by t.name;

select t.name, count(p.id)
from type t join product p
on t.id = p.type_id group by t.name;

select * from product p
join type t on p.type_id = t.id
where t.name in ('СЫР','МОЛОКО');

select t.name from type t
join product p on t.id = p.type_id
group by t.name
having count(p.id) < 10;

select p.name, t.name
from product p join type t
on p.type_id = t.id
group by p.name, t.name;

