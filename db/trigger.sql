create
or replace function taxes()
returns trigger as
$$
BEGIN
update products
set price = price + price * 0.13
where id = (select id from inserted);
return new;
END;
$$
LANGUAGE 'plpgsql';

create trigger tax_stat_trigger
after insert
on products
referencing new table as
inserted
for each statement
execute procedure taxes();

create
or replace function taxes_row()
returns trigger as
$$
BEGIN
update products
set price = price + price * 0.13
where id = new.id;
return NEW;
END;
$$
LANGUAGE 'plpgsql';

create trigger tax_row_trigger
before insert
on products
for each row
execute procedure taxes_row();

create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

create
or replace function price_history()
returns trigger as
$$
BEGIN
insert into history_of_price (name, price, date)
values (NEW.name, NEW.price, CURRENT_TIMESTAMP);
return NEW;
END;
$$
LANGUAGE 'plpgsql';

create trigger price_history_trigger
after insert
on history_of_price
for each row
execute procedure price_history();