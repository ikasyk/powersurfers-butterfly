package io.powersurfers.butterfly.controller;

import io.powersurfers.butterfly.exception.NoSuchUserException;
import io.powersurfers.butterfly.model.User;
import io.powersurfers.butterfly.dao.UserRepository;
import io.powersurfers.butterfly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    // Security god 10000
    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) throws NoSuchUserException {
        return userService.getUserById(id);
    }
}
