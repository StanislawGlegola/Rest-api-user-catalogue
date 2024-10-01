package pl.sg.usercatalog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sg.usercatalog.model.UserDAO;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<UserDAO> getUserList() {
        return namedParameterJdbcTemplate.query("SELECT id, username, age, email, gender, description, modified, modificationDate, registrationDate FROM users", BeanPropertyRowMapper.newInstance(UserDAO.class));
    }

    @Override
    public UserDAO getUserById(long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        return namedParameterJdbcTemplate.queryForObject("SELECT id, username, age, email, gender, description, modified, modificationDate, registrationDate FROM users WHERE id = :id", params, BeanPropertyRowMapper.newInstance(UserDAO.class));
    }

    @Override
    public void addUser(List<UserDAO> userList) {
        userList.forEach(user -> {
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("username", user.getUserName());
            params.addValue("age", user.getAge());
            params.addValue("email", user.getEmail());
            params.addValue("gender", user.getGender().name());
            params.addValue("description", user.getDescription());
            params.addValue("modificationDate", user.getModificationDate());
            params.addValue("registrationDate", user.getRegistrationDate());
            params.addValue("modified", String.valueOf(user.isModified()));
            namedParameterJdbcTemplate.update("INSERT INTO users(username, age, email, gender, description, modificationDate, registrationDate, modified) values(:username, :age, :email, :gender, :description, :modificationDate, :registrationDate, :modified)", params);
        });
    }

    @Override
    public void updateUser(UserDAO user) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("username", user.getUserName());
        params.addValue("age", user.getAge());
        params.addValue("email", user.getEmail());
        params.addValue("gender", user.getGender().name());
        params.addValue("description", user.getDescription());
        params.addValue("modificationDate", user.getModificationDate());
        params.addValue("registrationDate", user.getRegistrationDate());
        params.addValue("modified", String.valueOf(user.isModified()));
        params.addValue("id", user.getId());
        namedParameterJdbcTemplate.update("UPDATE users SET username = :username, age = :age, email = :email, gender = :gender, description = :description, modificationDate = :modificationDate, registrationDate = :registrationDate, modified  = :modified WHERE id = :id", params);
    }

    @Override
    public void deleteUserById(long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        namedParameterJdbcTemplate.update("DELETE FROM users WHERE id = :id", params);
    }
}