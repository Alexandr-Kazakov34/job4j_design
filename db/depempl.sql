CREATE TABLE departments (
	id serial primary key,
    name VARCHAR(255)
);
CREATE TABLE employees (
	id serial primary key,
    name VARCHAR(255),
    department_id int REFERENCES departments(id)
);
INSERT INTO departments (name) VALUES ('HR'), ('IT'), ('Sales'), ('Marketing');
INSERT INTO departments (name) VALUES ('Devops'), ('Developer');
INSERT INTO employees (name, department_id) VALUES
('Alice', 1),
('Bob', 2),
('Charlie', 3),
('David', 4);
INSERT INTO employees (name, department_id) VALUES
(null , 5),
('Bob', 6);

select d.name, e.name
from employees e left join departments d
on e.department_id = d.id;

select d.name as Position, e.name as Name
from departments d right join employees e
on e.department_id = d.id;

select d.name as Position, e.name as Name
from departments d full join employees e
on e.department_id = d.id;

select d.name as Position, e.name as Name
from departments d cross join employees e;

select d.name
from departments d left join employees e
on d.id = e.department_id
where e.name is null;

SELECT d.name AS department, e.name AS employee
FROM departments d
LEFT JOIN employees e ON d.id = e.department_id;

SELECT d.name AS department, e.name AS employee
FROM employees e
RIGHT JOIN departments d ON d.id = e.department_id;


CREATE TABLE teens (
	id serial primary key,
    name VARCHAR(255),
    gender CHAR(1)
);
INSERT INTO teens (name, gender) VALUES
('Вася', 'M'),
('Петя', 'M'),
('Маша', 'Ж'),
('Аня', 'Ж');

SELECT t1.name AS boy, t2.name AS girl
FROM teens t1
CROSS JOIN teens t2
WHERE t1.gender = 'M' AND t2.gender = 'Ж' AND t1.id < t2.id;