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



# complex queries
