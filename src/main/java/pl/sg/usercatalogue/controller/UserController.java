package pl.sg.usercatalogue.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sg.usercatalogue.model.User;
import pl.sg.usercatalogue.service.UserService;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<User> getUsersList() {
        return userService.getUserList();
    }

    @GetMapping(path = "/user/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/user/")
    public int addUser(@RequestBody List<User> userList) {
        return userService.addUser(userList);
    }

    @DeleteMapping(path = "/user/{id}")
    public int deleteUserById(@PathVariable("id") long id) {
        return userService.deleteUserById(id);
    }

    @PutMapping(path = "/user/{id}")
    public int updateUser(@PathVariable("id") long id, @RequestBody User updatedUser) {
        User user = userService.getUserById(id);

        if (user != null) {
            user.setUserName(updatedUser.getUserName());
            user.setAge(updatedUser.getAge());
            userService.updateUser(user);
            return 1;
        } else {
            //TODO Throw exception
            return -1;
        }
    }

    @PatchMapping(path = "/user/{id}")
    public int updateUserField(@PathVariable("id") long id, @RequestBody User updatedUser) {
        User user = getUserById(id);
        if (user != null) {
            if (updatedUser.getUserName() != null) user.setUserName(updatedUser.getUserName());
            if (updatedUser.getAge() > 0) user.setAge(updatedUser.getAge());
            userService.updateUser(user);
            return 1;
        } else {
            //TODO Throw exception
            return -1;
        }
    }
}