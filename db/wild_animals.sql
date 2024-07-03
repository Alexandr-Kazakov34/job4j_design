CREATE TABLE wild_animals
(
    id             serial primary key,
    name           text,
    avg_age        int,
    discovery_date date,
    habitat_id     int
);
CREATE TABLE habitats
(
    id             serial primary key,
    habitat_name   text,
    climate        text
);
INSERT INTO habitats (habitat_name, climate) VALUES
('Ocean', 'Aquatic'),
('Savannah', 'Dry'),
('Rainforest', 'Humid'),
('Desert', 'Arid'),
('Tundra', 'Cold');
INSERT INTO wild_animals (name, avg_age, discovery_date, habitat_id) VALUES
('Goldfish', 15000, '1820-05-01', 1),
('Catfish', 18000, '1890-07-23', 1),
('Starfish', 20000, NULL, 1),
('Lion', 20000, '1758-01-01', 2),
('Elephant', 70000, '1900-11-20', 2),
('Blue Whale', 80000, '1804-06-12', 1),
('Shark', 30000, '1700-01-01', 1),
('Parrot', 50000, NULL, 3),
('Falcon', 12000, '1200-05-05', 4),
('Jellyfish', 5000, '1850-08-08', 1);
select w.name, h.habitat_name
from wild_animals w join habitats h on w.habitat_id = h.id;
select w.name as Name, w.discovery_date as Date, h.habitat_name as Habitat, h.climate as Climate
from wild_animals w join habitats h on w.habitat_id = h.id;
select w.name as "Name animal", w.avg_age as "Age animal", w.discovery_date Date, h.habitat_name Habitat, h.climate Climate
from wild_animals w join habitats h on w.habitat_id = h.id;