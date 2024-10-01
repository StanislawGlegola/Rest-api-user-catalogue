package pl.sg.usercatalog.repository;

import pl.sg.usercatalog.model.UserDAO;

import java.util.List;

public interface UserRepository {
    List<UserDAO> getUserList();

    UserDAO getUserById(long userId);

    void addUser(List<UserDAO> userList);

    void deleteUserById(long id);

    void updateUser(UserDAO user);
}
