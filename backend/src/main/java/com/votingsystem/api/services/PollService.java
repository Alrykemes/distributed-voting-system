package com.votingsystem.api.services;

import com.votingsystem.api.domain.poll.Poll;
import com.votingsystem.api.domain.poll.PollRequestDto;
import com.votingsystem.api.domain.user.UserPoll;
import com.votingsystem.api.repository.PollRepository;
import com.votingsystem.api.repository.UserPollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PollService {

    private final PollRepository pollRepository;

    public List<Poll> getAll() {
        return pollRepository.findAll();
    }

    public Poll createPoll(PollRequestDto dto, UserPoll user) throws Exception {
        Poll poll = new Poll();
        return savePoll(dto, poll, user);
    }

    public Poll getPollById(String id) throws Exception {
        return pollRepository.findById(id).orElseThrow(() -> new RuntimeException("Poll not found"));
    }

    public Poll updatePoll(String id, PollRequestDto dto, UserPoll user) throws Exception {
        Poll poll = pollRepository.findById(id).orElseThrow(() -> new RuntimeException("Poll not found"));
        return savePoll(dto, poll, user);
    }

    private Poll savePoll(PollRequestDto dto, Poll poll, UserPoll user) throws Exception {
        poll.setTitle(dto.title());
        poll.setDescription(dto.description());
        poll.setOwner(user);
        poll.setPositiveNumberOfVotes(0L);
        poll.setNegativeNumberOfVotes(0L);
        return pollRepository.save(poll);
    }

    public Poll delete(String id) throws Exception {
        Poll poll = pollRepository.findById(id).orElseThrow(() -> new RuntimeException("Poll not found"));
        pollRepository.delete(poll);
        return poll;
    }
}