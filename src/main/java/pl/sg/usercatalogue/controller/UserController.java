package pl.sg.usercatalogue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(path = "/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(path ="/test")
    public int test() {
        return 1;
    }
}
