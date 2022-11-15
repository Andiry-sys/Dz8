package com.step.dz8.service;

import com.step.dz8.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> fetchUsers();
    User updateUser(User user,Long Id);
    void deleteUser(Long Id);
}
