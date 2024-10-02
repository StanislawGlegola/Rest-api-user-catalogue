package pl.sg.users.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import pl.sg.users.model.UserDTO;

import static java.lang.System.getenv;

@Configuration
@EnableRedisRepositories
public class RedisClient {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        jedisConFactory.setHostName(getenv("REDIS_HOST"));
        jedisConFactory.setPort(Integer.parseInt(getenv("REDIS_PORT")));
        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, UserDTO> redisTemplate() {
        RedisTemplate<String, UserDTO> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
