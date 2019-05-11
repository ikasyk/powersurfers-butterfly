package io.powersurfers.butterfly.service;

import io.powersurfers.butterfly.dao.UserRepository;
import io.powersurfers.butterfly.exception.NoSuchUserException;
import io.powersurfers.butterfly.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id) throws NoSuchUserException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) throw new NoSuchUserException();
        return optionalUser.get();
    }
}
