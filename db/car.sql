CREATE TABLE car_bodies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE car_engines (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE car_transmissions (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255)
);
CREATE TABLE cars (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    body_id int REFERENCES car_bodies(id),
    engine_id int REFERENCES car_engines(id),
    transmission_id int REFERENCES car_transmissions(id)
);
INSERT INTO car_bodies (name) VALUES
('Sedan'),
('Hatchback'),
(null),
('Coupe');
INSERT INTO car_engines (name) VALUES
('V6'),
('V8'),
('Electric'),
(null);
INSERT INTO car_transmissions (name) VALUES
('Manual'),
('Automatic'),
('CVT'),
(null);
INSERT INTO cars (name, body_id, engine_id, transmission_id) VALUES
('Model S', 1, 3, 2),
('Mustang', 4, 2, 1),
('Civic', 2, 1, 2),
('Rav4', 3, 4, 3);

select c.name, b.name, e.name, t.name
from cars c
left join car_bodies b on c.body_id = b.id
left join car_engines e on c.engine_id = e.id
left join car_transmissions t on c.transmission_id = t.id;

select b.name
from car_bodies b
left join cars c
on b.id = c.body_id
where c.body_id is null;

select e.name
from car_engines e
left join cars c
on e.id = c.engine_id
where c.engine_id is null;

select t.name
from car_transmissions t
left join cars c
on t.id = c.transmission_id
where c.transmission_id is null;