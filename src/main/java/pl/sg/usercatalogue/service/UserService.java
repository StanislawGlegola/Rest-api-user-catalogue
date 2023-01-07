package pl.sg.usercatalogue.service;

import org.springframework.stereotype.Service;
import pl.sg.usercatalogue.model.User;
import pl.sg.usercatalogue.repository.JDBCUserRepository;

import java.util.List;

@Service
public class UserService {

    private JDBCUserRepository jdbcUserRepository;

    public UserService(JDBCUserRepository jdbcUserRepository){
        this.jdbcUserRepository = jdbcUserRepository;
    }

    public List<User> getUserList() {
        return jdbcUserRepository.getUserList();
    }

    public User getUserById(long userId) {
        return jdbcUserRepository.getUserById(userId);
    }

    public int addUser(List<User> userList) {
        jdbcUserRepository.addUser(userList);
        return 1;
    }

    public void updateUser(User user) {
        jdbcUserRepository.updateUser(user);
    }

    public int deleteUserById(long id) {
        jdbcUserRepository.deleteUserById(id);
        return 1;
    }
}