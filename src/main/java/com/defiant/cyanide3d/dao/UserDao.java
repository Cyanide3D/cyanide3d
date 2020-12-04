package com.defiant.cyanide3d.dao;

import com.defiant.cyanide3d.models.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);
    void saveUserRole(String role, User user);
    void update(User user);
    void delete(User user);
    User findUserByUsername(String username);
    List<List> getAll();
}
