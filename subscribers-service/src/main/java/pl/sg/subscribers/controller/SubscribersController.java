package pl.sg.subscribers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sg.subscribers.model.Subscribers;
import pl.sg.subscribers.service.SubscribersService;

import java.util.List;

@RestController
@RequestMapping("/subscribers")
public class SubscribersController {
    private final SubscribersService subscribersService;

    @Autowired
    public SubscribersController(SubscribersService subscribersService) {
        this.subscribersService = subscribersService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Subscribers>> getSubscribersListByUserId(@PathVariable long userId) {
        return new ResponseEntity<>(subscribersService.getSubscribersListByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addSubscription(@RequestBody Subscribers subscribers) {
        subscribersService.addSubscription(subscribers);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/addList")
    public ResponseEntity<Boolean> addSubscribers(@RequestBody List<Subscribers> subscribersList) {
        if (subscribersService.addSubscribers(subscribersList)) {
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteSubscription(@RequestBody Subscribers subscribers) {
        subscribersService.deleteSubscription(subscribers);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}