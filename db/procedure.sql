create
or replace function delete_data(u_count integer, tax float, u_id integer)
returns integer
language 'plpgsql'
as
$$
    declare
        result integer;
    begin
	if u_count = 0 THEN
	delete from products;
	end if;
	return result;
	end;
	$$;
	select delete_data(0,0,0);

create
or replace procedure delete_data_id(u_id integer)
language 'plpgsql'
as $$
    BEGIN
	delete from products where id = u_id;
	END;
	$$;
call delete_data_id(4);