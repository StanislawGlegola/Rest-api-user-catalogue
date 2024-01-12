package pl.sg.usercatalog.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RedisHash("User")
public class User implements Serializable {
    private long id;
    private String userName;
    private int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}