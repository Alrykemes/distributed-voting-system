package com.votingsystem.api.repository;

import com.votingsystem.api.domain.poll.Poll;
import com.votingsystem.api.domain.user.User;
import org.springframework.data.domain.Limit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PollRepository extends MongoRepository<Poll, String> {
    List<Poll> findAllByOwner(User owner);

    List<Poll> findAllByTitleLikeIgnoreCase(String title, Limit limit);

    List<Poll> findTop3ByOrderByNegativeNumberOfVotesAsc();

    List<Poll> findTop3ByOrderByPositiveNumberOfVotesAsc();
}




