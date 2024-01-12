package pl.sg.usercatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sg.usercatalog.model.User;
import pl.sg.usercatalog.repository.JDBCUserRepository;

import java.util.List;

@Service
@EnableCaching
public class UserService {

    private JDBCUserRepository jdbcUserRepository;

    @Autowired
    public UserService(JDBCUserRepository jdbcUserRepository) {
        this.jdbcUserRepository = jdbcUserRepository;
    }

    @Cacheable(value = "users")
    public List<User> getUserList() {
        System.out.println("Data not cached, getting users from database.");
        return jdbcUserRepository.getUserList();
    }

    @Cacheable(value = "users")
    public User getUserById(long userId) {
        System.out.println("Data not cached, getting users from database.");
        return jdbcUserRepository.getUserById(userId);
    }

    @Transactional
    @CacheEvict(value = "users", allEntries = true)
    public void addUser(List<User> userList) {
        jdbcUserRepository.addUser(userList);
    }

    @Transactional
    @CacheEvict(value = "users", allEntries = true)
    public void updateUser(User user) {
        jdbcUserRepository.updateUser(user);
    }

    @Transactional
    @CacheEvict(value = "users", allEntries = true)
    public void deleteUserById(long id) {
        jdbcUserRepository.deleteUserById(id);
    }
}