package pl.sg.users.repository;

import pl.sg.users.model.UserDAO;

import java.util.List;

public interface UserRepository {
    List<UserDAO> getUserList();

    UserDAO getUserById(long userId);

    void addUser(List<UserDAO> userList);

    void deleteUserById(long id);

    void updateUser(UserDAO user);
}
