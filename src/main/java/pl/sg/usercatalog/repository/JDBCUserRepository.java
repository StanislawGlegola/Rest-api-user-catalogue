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
        return jdbcTemplate.query("SELECT id, username, age FROM userCatalog.user",
                BeanPropertyRowMapper.newInstance(User.class));
    }

    @Override
    public User getUserById(long userId) {
        return jdbcTemplate.queryForObject("SELECT id, username, age FROM userCatalog.user WHERE id = ?",
                BeanPropertyRowMapper.newInstance(User.class),
                userId);
    }

    @Override
    public void addUser(List<User> userList) {
        userList.forEach(user -> jdbcTemplate
                .update("INSERT user(username, age) values(?,?)",
                        user.getUserName(), user.getAge()
                ));
    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE user SET username = ?, age = ? WHERE id = ? ",
                user.getUserName(), user.getAge(), user.getId());
    }

    @Override
    public void deleteUserById(long id) {
        jdbcTemplate.update("DELETE from userCatalog.user WHERE id = ?"
                , id);
    }
}