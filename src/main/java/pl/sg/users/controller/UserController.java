package pl.sg.usercatalog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sg.usercatalog.model.UserDTO;
import pl.sg.usercatalog.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<UserDTO>> getUsersList() {
        List<UserDTO> userList = userService.getUserList();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        UserDTO user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Void> addUser(@RequestBody List<UserDTO> userList) {
        userService.addUser(userList);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") long id, @RequestBody UserDTO updatedUser) {
        UserDTO user = userService.getUserById(id);
        user.setUserName(updatedUser.getUserName());
        user.setAge(updatedUser.getAge());
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(path = "/update-field/{id}")
    public ResponseEntity<Void> updateUserField(@PathVariable("id") long id, @RequestBody UserDTO updatedUser) {
        UserDTO user = userService.getUserById(id);
        if (updatedUser.getAge() != user.getAge())
            user.setAge(updatedUser.getAge());
        if (!updatedUser.getUserName().equals(user.getUserName()))
            user.setUserName(updatedUser.getUserName());
        if (!updatedUser.getEmail().equals(user.getEmail()))
            user.setEmail(updatedUser.getEmail());
        if (!updatedUser.getGender().equals(user.getGender()))
            user.setGender(updatedUser.getGender());
        if (!updatedUser.getDescription().equals(user.getDescription()))
            user.setDescription(updatedUser.getDescription());

        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}