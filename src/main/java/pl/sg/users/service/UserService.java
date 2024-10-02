package pl.sg.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pl.sg.users.model.UserDAO;
import pl.sg.users.model.UserDTO;
import pl.sg.users.repository.UserRepositoryImpl;

import java.time.LocalDateTime;
import java.util.List;

@Service
@EnableCaching
@EnableTransactionManagement
public class UserService {

    private UserRepositoryImpl userRepositoryImpl;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepositoryImpl userRepositoryImpl, UserMapper userMapper) {
        this.userRepositoryImpl = userRepositoryImpl;
        this.userMapper = userMapper;
    }

    @Cacheable(value = "usersList", keyGenerator = "customKeyGenerator")
    public List<UserDTO> getUserList() {
        System.out.println("Data not cached, getting users from database.");
        return userMapper.toUserDTOList(userRepositoryImpl.getUserList());
    }

    @Cacheable(value = "users", key = "#id")
    public UserDTO getUserById(long id) {
        return userMapper.toUserDTO(userRepositoryImpl.getUserById(id));
    }

    @Transactional
    @CacheEvict(value = "usersList", allEntries = true)
    public void addUser(List<UserDTO> userList) {
        List<UserDAO> userDAOList = userMapper.toUserDAOList(userList);
        for (UserDAO userDAO : userDAOList) {
            userDAO.setRegistrationDate(LocalDateTime.now());
            userDAO.setModificationDate(null);
            userDAO.setModified(false);
        }
        userRepositoryImpl.addUser(userDAOList);
    }

    @Transactional
    @Caching(evict = {@CacheEvict(value = "usersList", allEntries = true), @CacheEvict(value = "users", key = "#userDTO.id")})
    public void updateUser(UserDTO userDTO) {
        UserDAO userDAO = userMapper.toUserDAO(userDTO);
        userDAO.setModificationDate(LocalDateTime.now());
        userDAO.setModified(true);
        userRepositoryImpl.updateUser(userDAO);
    }

    @Transactional
    @Caching(evict = {@CacheEvict(value = "usersList", allEntries = true), @CacheEvict(value = "users", key = "#id")})
    public void deleteUserById(long id) {
        userRepositoryImpl.deleteUserById(id);
    }
}