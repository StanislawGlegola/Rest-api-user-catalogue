package pl.sg.usercatalog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sg.usercatalog.model.User;

import java.util.List;

@Repository
public class JDBCUserRepository implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> getUserList() {
        return jdbcTemplate.query("SELECT id, username, age, email, gender, description, modified, modificationDate, registrationDate FROM users", BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public User getUserById(long id) {
        return jdbcTemplate.queryForObject("SELECT id, username, age, email, gender, description, modified, modificationDate, registrationDate FROM users " + "WHERE id = ?", BeanPropertyRowMapper.newInstance(User.class),
                id);
    }

    @Override
    public void addUser(List<User> userList) {
        userList.forEach(user -> jdbcTemplate.update("INSERT users(username, age, email, gender, description, modificationDate, registrationDate, modified) values(?,?,?,?,?,?,?,?)",
                user.getUserName(), user.getAge(), user.getEmail(), user.getGender().name(), user.getDescription(), user.getModificationDate(), user.getRegistrationDate(), user.isModified()));
    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE users SET username = ?, age = ?, email = ?, gender = ?, description = ?, modificationDate = ?, registrationDate = ?, modified  = ? WHERE id = ? ",
                user.getUserName(), user.getAge(), user.getEmail(), user.getGender().name(), user.getDescription(), user.getModificationDate(), user.getRegistrationDate(), user.isModified(), user.getId());
    }

    @Override
    public void deleteUserById(long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?",
                id);
    }
}