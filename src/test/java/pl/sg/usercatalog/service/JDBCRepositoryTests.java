package pl.sg.usercatalog.service;

import org.junit.Test;
import org.mockito.Mockito;
import pl.sg.usercatalog.model.Gender;
import pl.sg.usercatalog.model.User;
import pl.sg.usercatalog.repository.JDBCUserRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class JDBCRepositoryTests {

    final JDBCUserRepository jdbcUserRepository = mock(JDBCUserRepository.class);

    @Test
    public void shouldMockUsersList() {
        //given
        User user = new User("Viktor", 100, "Viktor@sg.com", "Hello", LocalDateTime.now(), LocalDateTime.now(), true, Gender.MALE);
        User user2 = new User("Volodymyr", 44, "Volodymyr@sg.pl", "Hello", LocalDateTime.now(), LocalDateTime.now(), true, Gender.MALE);
        User user3 = new User("Petro", 30, "Petro@sg.pl", "Hello", LocalDateTime.now(), LocalDateTime.now(), true, Gender.MALE);
        Mockito.when(jdbcUserRepository.getUserList()).thenReturn(Arrays.asList(user, user2));

        //when
        List<User> userList = jdbcUserRepository.getUserList();

        //then
        assertThat(userList)
                .hasSize(2)
                .isEqualTo(Arrays.asList(user, user2))
                .doesNotContain(user3);
    }
}