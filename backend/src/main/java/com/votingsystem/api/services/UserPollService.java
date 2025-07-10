package com.votingsystem.api.services;

import com.votingsystem.api.domain.user.UserPoll;
import com.votingsystem.api.repository.UserPollRepository;
import com.votingsystem.api.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPollService {

    private final UserPollRepository userPollRepository;
    private final JwtService jwtService;

    public UserPoll getById(String id) {
        return userPollRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
