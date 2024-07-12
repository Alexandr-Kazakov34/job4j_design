create table good
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);
insert into good (name, producer, count, price)
VALUES ('chese', 'producer_1', 3, 50);
insert into good (name, producer, count, price)
VALUES ('bread', 'producer_2', 15, 32);
insert into good (name, producer, count, price)
VALUES ('limon', 'producer_3', 8, 115);

insert into good (name, count, price) VALUES ('vodka', 11, 64);
delete from good where price = 115;
update good set price = 75 where name = 'chese';

begin transaction;
begin transaction;
commit;

begin transaction isolation repeatable read;
begin transaction isolation repeatable read;

select sum(count) from good;
update good set count = 26 where name = 'chese';
select sum(count) from good;
update good set count = 26 where name = 'bread';