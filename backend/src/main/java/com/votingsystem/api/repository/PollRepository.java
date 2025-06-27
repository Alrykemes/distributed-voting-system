package com.votingsystem.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PollRepository extends MongoRepository<String, String> {
}
