package pl.sg.usercatalog.repository;

import pl.sg.usercatalog.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getUserList();

    User getUserById(long userId);

    void addUser(List<User> userList);

    void deleteUserById(long id);

    void updateUser(User user);
}
