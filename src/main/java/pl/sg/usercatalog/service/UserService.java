package pl.sg.usercatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sg.usercatalog.model.User;
import pl.sg.usercatalog.repository.JDBCUserRepository;

import java.util.List;

@Service
public class UserService {

    private JDBCUserRepository jdbcUserRepository;

    @Autowired
    public UserService(JDBCUserRepository jdbcUserRepository){
        this.jdbcUserRepository = jdbcUserRepository;
    }

    public List<User> getUserList() {
        return jdbcUserRepository.getUserList();
    }

    public User getUserById(long userId) {
        return jdbcUserRepository.getUserById(userId);
    }

    @Transactional
    public int addUser(List<User> userList) {
        jdbcUserRepository.addUser(userList);
        return 1;
    }

    @Transactional
    public void updateUser(User user) {
        jdbcUserRepository.updateUser(user);
    }

    @Transactional
    public int deleteUserById(long id) {
        jdbcUserRepository.deleteUserById(id);
        return 1;
    }
}