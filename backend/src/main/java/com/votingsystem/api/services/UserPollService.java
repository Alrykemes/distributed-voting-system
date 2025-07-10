package com.votingsystem.api.services;

import com.votingsystem.api.domain.poll.Poll;
import com.votingsystem.api.domain.user.UserPoll;
import com.votingsystem.api.repository.PollRepository;
import com.votingsystem.api.repository.UserPollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPollService {

    private final UserPollRepository userPollRepository;
    private final PollRepository pollRepository;

    public UserPoll delete(UserPoll userPoll) throws Exception {
        UserPoll userDeleted = userPollRepository.findById(userPoll.getId()).orElseThrow(() -> new Exception("User not found"));
        userPollRepository.delete(userPoll);
        return userDeleted;
    }

    public List<Poll> deletePolls(UserPoll userPoll) throws Exception {
        List<Poll> pollsDeleted = pollRepository.findAllByOwner(userPoll);
        pollRepository.deleteAllByOwner(userPoll);
        return pollsDeleted;
    }
}
