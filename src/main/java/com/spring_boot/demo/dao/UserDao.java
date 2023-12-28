package com.spring_boot.demo.dao;


import com.spring_boot.demo.model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    void update(User user);

    void delete(Long id);

    List<User> getAllUsers();

}

