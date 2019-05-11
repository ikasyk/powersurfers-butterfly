package io.powersurfers.butterfly.service;

import io.powersurfers.butterfly.dao.UserRepository;
import io.powersurfers.butterfly.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.getOne(id);
    }
}
