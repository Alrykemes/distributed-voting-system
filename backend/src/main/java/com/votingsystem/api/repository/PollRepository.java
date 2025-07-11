package com.votingsystem.api.repository;

import com.votingsystem.api.domain.poll.Poll;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PollRepository extends MongoRepository<Poll, String> {}
