package uts.asd.model.dao;

import uts.asd.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void save(User user);

    void updateUser(User user);

    void deleteUser(User user);

}




