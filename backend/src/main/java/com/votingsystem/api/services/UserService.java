package com.votingsystem.api.services;

import com.votingsystem.api.domain.user.User;
import com.votingsystem.api.exception.UserNotFoundException;
import com.votingsystem.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User deleteUser(User userRequested) {
        User user = findByIdOrThrow(userRequested.getId());
        userRepository.delete(user);
        return user;
    }

    public User findByIdOrThrow(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
}