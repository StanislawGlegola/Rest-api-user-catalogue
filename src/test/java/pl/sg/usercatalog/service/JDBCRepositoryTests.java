package pl.sg.usercatalog.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JDBCRepositoryTests {

    @Autowired
    private UserService userService;

    @Test
    void findAnyUsers() {
        assertThat(userService.getUserList()).isNotNull();
    }
}