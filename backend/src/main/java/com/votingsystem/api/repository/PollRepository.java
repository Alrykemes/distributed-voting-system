package com.votingsystem.api.repository;

import com.votingsystem.api.domain.poll.Poll;
import com.votingsystem.api.domain.user.UserPoll;
import org.springframework.data.domain.Limit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PollRepository extends MongoRepository<Poll, String> {
    void deleteAllByOwner(UserPoll userPoll);

    List<Poll> findAllByOwner(UserPoll owner);

    List<Poll> findAllByTitleLikeIgnoreCase(String title, Limit limit);

    List<Poll> findTop3ByOrderByNegativeNumberOfVotesAsc();

    List<Poll> findTop3ByOrderByPositiveNumberOfVotesAsc();
}
