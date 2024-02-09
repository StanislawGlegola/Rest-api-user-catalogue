package pl.sg.usercatalog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.sg.usercatalog.model.Subscribers;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SubscribersRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addSubscription(Subscribers subscribers) {
        jdbcTemplate.update("INSERT INTO subscribers(user_id, subscribes_to_id) values(?, ?)"
                , subscribers.getUserId(), subscribers.getSubscribesToId());
    }

    public void deleteSubscription(Subscribers subscribers) {
        jdbcTemplate.update("DELETE FROM subscribers WHERE user_id = ? AND subscribes_to_id = ?"
                , subscribers.getUserId(), subscribers.getSubscribesToId());
    }

    public void addSubscribers(List<Subscribers> subscribersList) {
        subscribersList.forEach(subscribers -> {
            jdbcTemplate.update("INSERT INTO subscribers(user_id, subscribes_to_id) values(?, ?)"
                    , subscribers.getUserId(), subscribers.getSubscribesToId());
        });
    }

    public List<Subscribers> getSubscribersListByUserId(long userId) {
        return jdbcTemplate.query(
                "SELECT * FROM subscribers WHERE user_id = ?"
                , BeanPropertyRowMapper.newInstance(Subscribers.class),
                userId);
    }

    public boolean isSubscribed(long userId, long subscribesToId) {
        return jdbcTemplate.queryForObject("SELECT EXISTS(SELECT * FROM subscribers WHERE user_id = ? AND subscribes_to_id = ?)"
                , Integer.class, userId, subscribesToId) > 0;
    }

    public void deleteEverySubscriptionByUserId(long userId) {
        jdbcTemplate.update("DELETE FROM subscribers WHERE user_id = ? OR subscribes_to_id = ?", userId, userId);
    }
}