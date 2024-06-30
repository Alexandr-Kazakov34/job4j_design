CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    hire_date int
);
CREATE TABLE projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
);
CREATE TABLE employee_projects (
	id SERIAL PRIMARY KEY,
    employee_id INT REFERENCES employees (id),
    project_id INT REFERENCES projects (id)
);
insert into employees(name) values ('Ivan');
insert into employees(name) values ('Kirill');
insert into employees(name) values ('Roman');

insert into projects(name) values ('Start Up');
insert into projects(name) values ('Interprise');
insert into projects(name) values ('Old School');

insert into employee_projects(employee_id, project_id) values (1, 1);
insert into employee_projects(employee_id, project_id) values (1, 2);
insert into employee_projects(employee_id, project_id) values (1, 3);
insert into employee_projects(employee_id, project_id) values (2, 1);
insert into employee_projects(employee_id, project_id) values (2, 2);
insert into employee_projects(employee_id, project_id) values (3, 3);
select * from employee_projects;