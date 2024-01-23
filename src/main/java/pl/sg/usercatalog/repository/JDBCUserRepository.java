package pl.sg.usercatalog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sg.usercatalog.model.UserDAO;

import java.util.List;

@Repository
public class JDBCUserRepository implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserDAO> getUserList() {
        return jdbcTemplate.query("SELECT id, username, age, email, gender, description, modified, modificationDate, registrationDate FROM users", BeanPropertyRowMapper.newInstance(UserDAO.class));
    }

    @Override
    public UserDAO getUserById(long id) {
        return jdbcTemplate.queryForObject("SELECT id, username, age, email, gender, description, modified, modificationDate, registrationDate FROM users " + "WHERE id = ?", BeanPropertyRowMapper.newInstance(UserDAO.class),
                id);
    }

    @Override
    public void addUser(List<UserDAO> userList) {
        userList.forEach(user -> jdbcTemplate.update("INSERT users(username, age, email, gender, description, modificationDate, registrationDate, modified) values(?,?,?,?,?,?,?,?)",
                user.getUserName(), user.getAge(), user.getEmail(), user.getGender().name(), user.getDescription(), user.getModificationDate(), user.getRegistrationDate(), String.valueOf(user.isModified())));
    }

    @Override
    public void updateUser(UserDAO user) {
        jdbcTemplate.update("UPDATE users SET username = ?, age = ?, email = ?, gender = ?, description = ?, modificationDate = ?, registrationDate = ?, modified  = ? WHERE id = ? ",
                user.getUserName(), user.getAge(), user.getEmail(), user.getGender().name(), user.getDescription(), user.getModificationDate(), user.getRegistrationDate(), String.valueOf(user.isModified()), user.getId());
    }

    @Override
    public void deleteUserById(long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?",
                id);
    }
}