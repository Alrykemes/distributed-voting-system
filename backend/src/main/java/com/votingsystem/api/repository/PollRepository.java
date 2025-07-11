package com.votingsystem.api.repository;

import com.votingsystem.api.domain.poll.Poll;
import com.votingsystem.api.domain.user.User;
import org.springframework.data.domain.Limit;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PollRepository extends MongoRepository<Poll, String> {
    List<Poll> findAllByOwner(User owner);

    List<Poll> findAllByTitleLikeIgnoreCase(String title, Limit limit);

    @Aggregation(pipeline = {
            "{ $addFields: { totalVotes: { $sum: '$pollOptions.votes' } } }",
            "{ $sort: { totalVotes: -1 } }",
            "{ $limit: 6 }"
    })
    List<Poll> findTop6ByTotalVotes();
}




