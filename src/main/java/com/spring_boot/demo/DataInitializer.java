
package com.spring_boot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args){
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, email VARCHAR(255), NAME VARCHAR(255), surname VARCHAR(255));");

        jdbcTemplate.execute("INSERT INTO users (email, name, surname) VALUES('user1@gmail.com', 'user1', 'surname1'),('user2@gmail.com', 'user2', 'surname2');");
    }
}
