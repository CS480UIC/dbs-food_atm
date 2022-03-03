# Glossary

## Table of Contents

- [location](#location)
- [warehouse](#warehouse)
- [atm](#atm)
- [food](#food)
- [user](#user)
- [Plural Attributes](#plural-attributes)

## location

Entity Name: Location

Synonyms: Place, Address

Description: A location denotes the specific place and address of an Food ATM machine. A location is not  the Food ATM itself, but rather describes where it is in geographical terms.

Attributes:
location_id: int NOT NULL
location_type: varchar(255)
address: varchar(255)

Relationships:
Location_has_atm: maxima - 1, minima - 0
Location_has_food: maxima - many, minima - 0
Location_has_warehouse: maxima - 1, minima - 0

## warehouse

Entity Name: Warehouse

Synonyms: Storage, Supply House, Distributer

Description: A warehouse is a facility that keeps the stock of food used to resupply the Food ATM machines. Warehouses are facilities specifically operated by the company, and do not include homes or other spaces where food is held.

Attributes:
warehouse_id: int NOT NULL
warehouse_location: int NOT NULL
warehouse_last_restocked: datetime
PRIMARY KEY CASCADE, FOREIGN KEY RESTRICT

Relationships:
Warehouse_has_location: maxima - 1, minima - 1

## atm

Entity Name: ATM

Synonyms: Machine, Pickup Location, Food ATM

Description: An ATM is a distribution machine placed at specific locations where users are able to spend allotted credits to get food items. ATMs are the specific machines that distribute, and are not warehouses or other spaces food may be distributed at.

Attributes:
atm_id: int NOT NULL
atm_location: int NOT NULL
atm_last_restocked: datetime
associated_warehouse: int
PRIMARY KEY CASCADE, FOREIGN KEY RESTRICT

Relationships:
atm_exists_at_location: maxima - 1, minima - 1
atm_restocked_by_warehouse: maxima - 1, minima - 1
Atm_supplies_user: maxima - many, minima - 0

## food

Entity Name: Food

Synonyms: Meal, Item

Description: Food denotes any item that is available in a Food ATM machine to clients of the organization. This food does not include the food in the warehouse, but only the items inside of the machines.

Attributes:
food_id: int NOT NULL
name: varchar(255)
food_location: int NOT NULL
quantity: int
PRIMARY KEY CASCADE, FOREIGN KEY RESTRICT

Relationships:
food_exists_at_location: maxima - 1, minima - 1

## user

Entity Name: User

Synonyms: Account, Person

Description: A user is any person who has an account with the non-profit food organization, and gets allotted a certain amount of credits based on their financial situation to use at any Food ATM.

Attributes:
user_id: int NOT NULL
password: varchar(20) NOT NULL
user_type: varchar(20) NOT NULL
balance: int

Relationships:
user_is _assigned_atm: maxima - many, minima - 0


## Plural Attributes

user and atm

We created the user_atm entity to implement the plural attributes of user_id and atm_id. Since user and atm have a many-many relationship, we created the user_atm table to store foreign keys for each primary key of the user table as well as the atm table.
