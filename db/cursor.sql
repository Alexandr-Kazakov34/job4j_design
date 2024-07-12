postgres=# select * from products;
 id |   name    | count | price
----+-----------+-------+-------
  2 | product_2 |    15 |    32
  4 | product_4 |    11 |    64
  1 | product_1 |     3 |    75
(3 ёЄЁюъш)


postgres=# delete from products;
DELETE 3
postgres=# drop table products;
DROP TABLE
postgres=# create table products
postgres-# (
postgres(#     id    serial primary key,
postgres(#     name  varchar(50),
postgres(#     count integer default 0,
postgres(#     price integer
postgres(# );
CREATE TABLE
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_1', 1, 5);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_2', 2, 10);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_3', 3, 15);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_4', 4, 20);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_5', 5, 25);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_6', 6, 30);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_7', 7, 35);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_8', 8, 40);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_9', 9, 45);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_10', 10, 50);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_11', 11, 55);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_12', 12, 60);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_13', 13, 65);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_14', 14, 70);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_15', 15, 75);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_16', 16, 80);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_17', 17, 85);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_18', 18, 90);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_19', 19, 95);
INSERT 0 1
postgres=# insert into products (name, count, price)
postgres-# VALUES ('product_20', 20, 100);
INSERT 0 1

postgres=# BEGIN;
BEGIN
postgres=*# DECLARE
postgres-*# cursor_products cursor for
postgres-*# select * from products;
DECLARE CURSOR

postgres=*# FETCH LAST FROM cursor_products;
 id |    name    | count | price
----+------------+-------+-------
 20 | product_20 |    20 |   100
(1 ёЄЁюър)


postgres=*# MOVE BACKWARD 5 FROM cursor_products;
MOVE 5
postgres=*#
postgres=*# MOVE BACKWARD 8 FROM cursor_products;
MOVE 8
postgres=*# MOVE BACKWARD 5 FROM cursor_products;
MOVE 5
postgres=*# FETCH PRIOR FROM cursor_products;
 id |   name    | count | price
----+-----------+-------+-------
  1 | product_1 |     1 |     5
(1 ёЄЁюър)


postgres=*# CLOSE cursor_products;
CLOSE CURSOR
postgres=*# COMMIT;
COMMIT
postgres=#