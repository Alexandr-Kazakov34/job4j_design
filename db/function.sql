create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);
INSERT INTO devices (name, price) VALUES ('Laptop', 1500.00);
INSERT INTO devices (name, price) VALUES ('Smartphone', 800.00);
INSERT INTO devices (name, price) VALUES ('Tablet', 600.00);
INSERT INTO devices (name, price) VALUES ('Smartwatch', 200.00);
INSERT INTO devices (name, price) VALUES ('Desktop', 1200.00);
INSERT INTO people (name) VALUES ('Alice');
INSERT INTO people (name) VALUES ('Bob');
INSERT INTO people (name) VALUES ('Charlie');
INSERT INTO devices_people (device_id, people_id) VALUES (1, 1);
INSERT INTO devices_people (device_id, people_id) VALUES (2, 1);
INSERT INTO devices_people (device_id, people_id) VALUES (3, 2);
INSERT INTO devices_people (device_id, people_id) VALUES (4, 2);
INSERT INTO devices_people (device_id, people_id) VALUES (5, 3);

select avg(price) as avg_dev_price from devices;
select avg(d.price)
from people p join devices_people dp
on p.id = dp.people_id join devices d
on d.id = dp.device_id group by p.name;
select avg(price) as avg_dev_price
from people p join devices_people dp
on p.id = dp.people_id join devices d
on d.id = dp.device_id group by p.name
having avg(d.price) > 5000;