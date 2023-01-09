package pl.sg.usercatalogue;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectionController {
    @GetMapping(path = "/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping(path ="/test")
    public int test() {
        return 1;
    }
}
