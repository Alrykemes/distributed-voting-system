package com.votingsystem.api.repository;


import com.votingsystem.api.domain.user.UserPoll;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserPollRepository extends MongoRepository<UserPoll, String> {

    Optional<UserPoll> findByEmail(String email);
}