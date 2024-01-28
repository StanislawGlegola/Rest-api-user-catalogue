package pl.sg.usercatalog.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import pl.sg.usercatalog.model.UserDAO;
import pl.sg.usercatalog.model.UserDTO;
import pl.sg.usercatalog.repository.UserRepositoryImpl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceCacheTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CacheManager cacheManager;

    @MockBean
    private UserRepositoryImpl userRepositoryImpl;

    @Test
    public void testCacheHit() {
        //given
        UserDTO user = new UserDTO();
        user.setId(1L);
        UserDAO userDAO = userMapper.toUserDAO(user);
        Cache usersCache = cacheManager.getCache("users");

        //when
        when(userRepositoryImpl.getUserById(1L)).thenReturn(userDAO);

        //then
        userService.getUserById(1L);
        assertNotNull(usersCache);
        assertEquals(user, usersCache.get(1L).get());
    }

    @Test
    public void testCacheEvictionByUpdate() {
        //given
        UserDTO user = new UserDTO();
        user.setId(1L);
        Cache usersCache = cacheManager.getCache("users");

        //when
        when(userRepositoryImpl.getUserById(1L)).thenReturn(userMapper.toUserDAO(user));

        //then
        userService.getUserById(1L);
        assertNotNull(usersCache.get(1L));
        userService.updateUser(user);
        assertNull(usersCache.get(1L));
    }
}