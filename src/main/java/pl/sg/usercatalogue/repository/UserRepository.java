package pl.sg.usercatalogue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sg.usercatalogue.model.User;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAll() {
        return jdbcTemplate.query("SELECT id, username, age FROM userCatalogue.user",
                BeanPropertyRowMapper.newInstance(User.class));
    }

    public User getById(long userId) {
        return jdbcTemplate.queryForObject("SELECT id, username, age FROM userCatalogue.user WHERE id = ?",
                BeanPropertyRowMapper.newInstance(User.class),
                userId);
    }
}