package pl.sg.usercatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sg.usercatalog.model.User;
import pl.sg.usercatalog.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public List<User> getUsersList() {
        return userService.getUserList();
    }

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/add")
    public int addUser(@RequestBody List<User> userList) {
        return userService.addUser(userList);
    }

    @DeleteMapping(path = "/delete/{id}")
    public int deleteUserById(@PathVariable("id") long id) {
        return userService.deleteUserById(id);
    }

    @PutMapping(path = "/update/{id}")
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

    @PatchMapping(path = "/update-field/{id}")
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