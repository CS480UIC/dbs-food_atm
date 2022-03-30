CREATE TABLE food (
	food_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    food_location INT NOT NULL,
    quantity INT,
    PRIMARY KEY (food_id),
    FOREIGN KEY (food_location) REFERENCES location(location_id) ON UPDATE CASCADE ON DELETE CASCADE
    );
