CREATE TABLE atm (
	atm_id INT NOT NULL AUTO_INCREMENT,
    atm_location INT NOT NULL,
    atm_last_restocked DATETIME,
    associated_warehouse INT,
    PRIMARY KEY (atm_id),
    FOREIGN KEY (atm_location) REFERENCES location(location_id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (associated_warehouse) REFERENCES warehouse(warehouse_id) ON UPDATE CASCADE ON DELETE CASCADE
    );