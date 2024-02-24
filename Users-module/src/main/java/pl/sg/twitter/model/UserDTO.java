package pl.sg.twitter.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@RedisHash("UserDTO")
public class UserDTO implements Serializable {
    @ApiModelProperty(hidden = true)
    private long id;
    private String userName;
    private int age;
    private Gender gender;
    private String email;
    private String description;
    private LocalDateTime registrationDate;
    private LocalDateTime modificationDate;
    private boolean modified;

    public UserDTO(String userName, int age, String email, String description, LocalDateTime registrationDate, LocalDateTime modificationDate, boolean modified, Gender gender) {
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