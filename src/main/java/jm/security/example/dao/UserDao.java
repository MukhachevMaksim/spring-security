package jm.security.example.dao;

import jm.security.example.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);
    User getUserById(Long id);
    void add(User user);
    void removeUserById(Long id);
    List<User> listUsers();
    void update(Long id, User user);
}
