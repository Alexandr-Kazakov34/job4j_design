insert into categories(name) values ('important');
insert into categories(name) values ('not important');
insert into categories(name) values ('urgent');

insert into roles(name) values ('Student');
insert into roles(name) values ('Pupil');
insert into roles(name) values ('Teacher');

insert into users(name, roles_id) values ('Dmitrii', 1);
insert into users(name, roles_id) values ('Igor', 2);
insert into users(name, roles_id) values ('Slava', 3);

insert into rules(name) values ('rules  college');
insert into rules(name) values ('rules  school');
insert into rules(name) values ('rules  university');

insert into states(name, users_id) values ('done', 1);
insert into states(name, users_id) values ('in progress', 2);
insert into states(name, users_id) values ('rejected', 3);

insert into items(name, users_id, categories_id, states_id) values ('First item', 1, 1, 1);
insert into items(name, users_id, categories_id, states_id) values ('Second item', 2, 2, 2);
insert into items(name, users_id, categories_id, states_id) values ('Third item', 3, 3, 3);

insert into comments(name, items_id) values ('This item is add', 1);
insert into comments(name, items_id) values ('This item is not add', 2);
insert into comments(name, items_id) values ('This item is invalid', 3);

insert into attachs(name, items_id) values ('???.png', 1);
insert into attachs(name, items_id) values ('???.txt', 2);
insert into attachs(name, items_id) values ('???.sql', 3);

insert into roles_rules(roles_id, rules_id) values (1, 1);
insert into roles_rules(roles_id, rules_id) values (2, 2);
insert into roles_rules(roles_id, rules_id) values (3, 3);