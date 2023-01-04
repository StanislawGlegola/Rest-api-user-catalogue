package pl.sg.usercatalogue.service;

import org.springframework.stereotype.Service;
import pl.sg.usercatalogue.model.User;
import pl.sg.usercatalogue.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUserList() {
        return userRepository.getAll();
    }

    public User getUserById(long userId) {
        return userRepository.getById(userId);
    }
}