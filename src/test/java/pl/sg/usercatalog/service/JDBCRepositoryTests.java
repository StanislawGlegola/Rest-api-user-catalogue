package pl.sg.usercatalog.service;

import org.junit.Test;
import org.mockito.Mockito;
import pl.sg.usercatalog.model.User;
import pl.sg.usercatalog.repository.JDBCUserRepository;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class JDBCRepositoryTests {

    final JDBCUserRepository jdbcUserRepository = mock(JDBCUserRepository.class);

    @Test
    public void shouldMockUsersList() {
        //given
        User user = new User("Viktor", 100);
        User user2 = new User("Volodymyr", 44);
        User user3 = new User("Petro", 30);
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