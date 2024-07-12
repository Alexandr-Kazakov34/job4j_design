postgres=# begin transaction;
BEGIN
postgres=*# select * from good;
 id | name  |  producer  | count | price
----+-------+------------+-------+-------
  4 | vodka |            |    11 |    64
  1 | chese | producer_1 |     3 |    75
  2 | bread | producer_2 |    26 |    32
(3 ёЄЁюъш)
BEGIN
postgres=*# delete from good;
DELETE 3
postgres=*# drop table good;
DROP TABLE
postgres=*# rollback transaction;
ROLLBACK
postgres=# select * from good;
 id | name  |  producer  | count | price
----+-------+------------+-------+-------
  4 | vodka |            |    11 |    64
  1 | chese | producer_1 |     3 |    75
  2 | bread | producer_2 |    26 |    32
(3 ёЄЁюъш)
postgres=# begin transaction;
BEGIN
postgres=*# savepoint first_savepoint;
SAVEPOINT
postgres=*# delete from good where price = 64;
DELETE 1
postgres=*# update good set price = 5 where name = 'bread';
UPDATE 1
postgres=*# select * from good;
 id | name  |  producer  | count | price
----+-------+------------+-------+-------
  1 | chese | producer_1 |     3 |    75
  2 | bread | producer_2 |    26 |     5
(2 ёЄЁюъш)


postgres=*# rollback to first_savepoint;
ROLLBACK
postgres=*# select * from good;
 id | name  |  producer  | count | price
----+-------+------------+-------+-------
  4 | vodka |            |    11 |    64
  1 | chese | producer_1 |     3 |    75
  2 | bread | producer_2 |    26 |    32
(3 ёЄЁюъш)


postgres=*# commit transaction;
COMMIT
postgres=#