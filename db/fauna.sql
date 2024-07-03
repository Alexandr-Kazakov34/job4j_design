create table fauna
(
    id             serial primary key,
    name           text,
    avg_age        int,
    discovery_date date
);
insert into fauna(name, avg_age, discovery_date)
values('Goldfish', 15000, '1820-05-01'),
('Catfish', 18000, '1890-07-23'),
('Lion', 20000, '1758-01-01'),
('Elephant', 70000, '1900-11-20'),
('Blue Whale', 80000, '1804-06-12'),
('Shark', 30000, '1700-01-01'),
('Falcon', 12000, '1200-05-05'),
('Jellyfish', 5000, '1850-08-08');
select * from fauna
where name like '%fish%';
select * from fauna
where avg_age between 10000 and 21000;
select * from fauna
where discovery_date is null;
select * from fauna
where discovery_date < '1950-01-01';