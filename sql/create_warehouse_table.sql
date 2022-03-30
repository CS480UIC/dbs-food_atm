CREATE TABLE warehouse(
    warehouse_id INT NOT NULL AUTO_INCREMENT,
    warehouse_location int NOT NULL,
    warehouse_last_restocked DATETIME,
    PRIMARY KEY(warehouse_id),
    FOREIGN KEY(warehouse_location) REFERENCES location(location_id) ON UPDATE CASCADE ON DELETE CASCADE
);