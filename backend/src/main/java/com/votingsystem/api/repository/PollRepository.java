package com.votingsystem.api.repository;

import com.votingsystem.api.domain.poll.Poll;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PollRepository extends MongoRepository<Poll, String> {
    List<Poll> findAllById(String userId);
}




