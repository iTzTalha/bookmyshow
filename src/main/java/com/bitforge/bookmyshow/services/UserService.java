package com.bitforge.bookmyshow.services;

import com.bitforge.bookmyshow.exceptions.DuplicateUserException;
import com.bitforge.bookmyshow.models.User;
import com.bitforge.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String email, String password) throws DuplicateUserException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            throw new DuplicateUserException("User already exists with the email id: " + email);
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setBookings(new ArrayList<>());
        return userRepository.save(user);
    }
}
