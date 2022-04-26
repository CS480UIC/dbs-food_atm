# simple queries
create view simple_0 as
SELECT * FROM food
WHERE quantity > 3
ORDER BY name;

create view simple_1 as
select *
from atm
where atm_id like '%45%'
order by associated_warehouse;

# aggregate queries
create view aggregate_0 as
SELECT SUM(balance) FROM user;

create view aggregate_1 as
SELECT user_type, sum(balance) FROM user GROUP BY user_type;

create view aggregate_2 as
select COUNT(warehouse_last_restocked)
from warehouse;

create view aggregate_3 as
select COUNT(user()) as count, user_type as type
from user
group by user_type;


# complex queries
create view complex_0 as
select location.address, warehouse.warehouse_id
from location
inner join warehouse
on location.location_id = warehouse.warehouse_location

CREATE VIEW complex_1 AS
SELECT food_location, quantity FROM food
WHERE 1 <=
	(SELECT COUNT(*)
     FROM location
     WHERE location_type = 2);

CREATE VIEW complex_2 AS
SELECT atm_id, atm_location FROM atm A
WHERE EXISTS
	(SELECT *
	 FROM warehouse
     WHERE warehouse_location = A.atm_location);

