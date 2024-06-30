create table roles_rules(
    id serial primary key,
	name varchar(255),
	roles_id int references roles(id),
	rules_id int references rules(id)
);