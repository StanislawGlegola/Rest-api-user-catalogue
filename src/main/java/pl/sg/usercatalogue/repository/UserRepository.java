package pl.sg.usercatalogue.repository;

import pl.sg.usercatalogue.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getUserList();

    User getUserById(long userId);

    void addUser(List<User> userList);

    void deleteUserById(long id);

    int updateUser(User user);
}
