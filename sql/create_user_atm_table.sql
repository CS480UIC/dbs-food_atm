CREATE TABLE user_atm (
	atm_id INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (atm_id, user_id),
    FOREIGN KEY (atm_id) REFERENCES atm(atm_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
    );
