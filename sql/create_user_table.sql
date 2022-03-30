CREATE TABLE users (
  user_id INT NOT NULL AUTO_INCREMENT,
  password VARCHAR(20) NOT NULL,
  user_type VARCHAR(20) NOT NULL,
  balance INT,
  PRIMARY KEY (user_id)
);