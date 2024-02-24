package pl.sg.twitter.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@RedisHash("UserDAO")
public class UserDAO {
    private long id;
    private String userName;
    private int age;
    private Gender gender;
    private String email;
    private String description;
    private LocalDateTime registrationDate;
    private LocalDateTime modificationDate;
    private boolean modified;

    public UserDAO(String userName, int age, String email, String description, LocalDateTime registrationDate, LocalDateTime modificationDate, boolean modified, Gender gender) {
        this.userName = userName;
        this.age = age;
        this.email = email;
        this.description = description;
        this.registrationDate = registrationDate;
        this.modificationDate = modificationDate;
        this.modified = modified;
        this.gender = gender;
    }
}