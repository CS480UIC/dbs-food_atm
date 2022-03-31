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
SELECT user_id, COUNT(user_type) FROM user;

create view aggregate_2 as
select COUNT(warehouse_last_restocked)
from warehouse;

create view aggregate_3 as
select COUNT(user()) as count, user_type as type
from user
group by user_type;


# complex queries
