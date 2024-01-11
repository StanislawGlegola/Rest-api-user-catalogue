package pl.sg.usercatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<User>> getUsersList() {
        List<User> userList = userService.getUserList();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Void> addUser(@RequestBody List<User> userList) {
        userService.addUser(userList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") long id, @RequestBody User updatedUser) {
        User user = userService.getUserById(id);
        user.setUserName(updatedUser.getUserName());
        user.setAge(updatedUser.getAge());
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(path = "/update-field/{id}")
    public ResponseEntity<Void> updateUserField(@PathVariable("id") long id, @RequestBody User updatedUser) {
        User user = userService.getUserById(id);
        if (updatedUser.getUserName() != userService.getUserById(id).getUserName())
            user.setUserName(updatedUser.getUserName());
        if (updatedUser.getAge() != userService.getUserById(id).getAge()) user.setAge(updatedUser.getAge());
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}