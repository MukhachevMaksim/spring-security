package jm.security.example.service;

import jm.security.example.model.User;

import java.util.List;

public interface UserService {
    User getUserByName(String name);
    User getUserById(Long id);
    void add(User user);
    void removeUserById(Long id);
    List<User> listUsers();
    void update(Long id, User user);
}
