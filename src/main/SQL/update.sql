USE kata;

CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, email VARCHAR(255), NAME VARCHAR(255), surname VARCHAR(255));


INSERT INTO users (email, name, surname) VALUES('user1@gmail.com', 'user1', 'surname1'),('user2@gmail.com', 'user2', 'surname2');