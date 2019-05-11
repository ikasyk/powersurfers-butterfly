package io.powersurfers.butterfly.controller;

import io.powersurfers.butterfly.model.User;
import io.powersurfers.butterfly.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // Security - Level - 10000000
    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
