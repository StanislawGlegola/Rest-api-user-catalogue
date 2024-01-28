package pl.sg.usercatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import pl.sg.usercatalog.model.UserDAO;
import pl.sg.usercatalog.model.UserDTO;
import pl.sg.usercatalog.repository.JDBCUserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@EnableCaching
@EnableTransactionManagement
public class UserService {

    private JDBCUserRepository jdbcUserRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(JDBCUserRepository jdbcUserRepository, UserMapper userMapper) {
        this.jdbcUserRepository = jdbcUserRepository;
        this.userMapper = userMapper;
    }

    @Cacheable(value = "usersList", keyGenerator = "customKeyGenerator")
    public List<UserDTO> getUserList() {
        System.out.println("Data not cached, getting users from database.");
        return userMapper.toUserDTOList(jdbcUserRepository.getUserList());
    }

    @Cacheable(value = "users", key = "#id")
    public UserDTO getUserById(long id) {
        return userMapper.toUserDTO(jdbcUserRepository.getUserById(id));
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
        jdbcUserRepository.addUser(userDAOList);
    }

    @Transactional
    @Caching(evict = {@CacheEvict(value = "usersList", allEntries = true), @CacheEvict(value = "users", key = "#userDTO.id")})
    public void updateUser(UserDTO userDTO) {
        UserDAO userDAO = userMapper.toUserDAO(userDTO);
        userDAO.setModificationDate(LocalDateTime.now());
        userDAO.setModified(true);
        jdbcUserRepository.updateUser(userDAO);
    }

    @Transactional
    @Caching(evict = {@CacheEvict(value = "usersList", allEntries = true), @CacheEvict(value = "users", key = "#id")})
    public void deleteUserById(long id) {
        jdbcUserRepository.deleteUserById(id);
    }
}