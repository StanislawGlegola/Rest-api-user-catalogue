package pl.sg.usercatalogue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sg.usercatalogue.model.User;
import pl.sg.usercatalogue.service.UserService;

import java.util.List;

@RestController
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<User>getUsersList(){
        return userService.getUserList();
    }

    @GetMapping(path = "/user/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
}