package io.powersurfers.butterfly.controller;

import io.powersurfers.butterfly.model.User;
import io.powersurfers.butterfly.dao.UserRepository;
import io.powersurfers.butterfly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService userService;

    // Security god 10000
    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }
}
