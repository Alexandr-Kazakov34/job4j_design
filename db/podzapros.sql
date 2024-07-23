CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

insert into customers (first_name ,last_name, age, country)
values ('Alex', 'Kazakov', 35, 'Russia');
insert into customers (first_name ,last_name, age, country)
values('Pasha', 'Petrov', 25, 'Poland');
 insert into customers (first_name ,last_name, age, country)
values('Alex', 'Ivanov', 15, 'USA');
 insert into customers (first_name ,last_name, age, country)
values('Sergei', 'Sidorov', 55, 'China');
 insert into customers (first_name ,last_name, age, country)
values('Vani', 'Popov', 30, 'Peru');

select * from customers
where age > (select MIN(age) from customers);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into orders (amount,customer_id)
values (5, 1);
insert into orders (amount,customer_id)
values (1, 2);
 insert into orders (amount,customer_id)
values (10, 3);

select * from customers
where customers.id not in (select customer_id from orders);