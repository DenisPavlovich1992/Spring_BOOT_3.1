package com.spring_boot.demo.service;


import com.spring_boot.demo.model.User;

import java.util.List;

public interface UserService {

    void add(User user);

    User getUserById(Long id);

    void update(User user);

    void delete(Long id);

    List<User> getAllUsers();

}
