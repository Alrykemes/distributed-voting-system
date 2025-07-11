package com.votingsystem.api.services;

import com.votingsystem.api.domain.poll.Poll;
import com.votingsystem.api.domain.poll.PollRequestDto;
import com.votingsystem.api.domain.user.User;
import com.votingsystem.api.exception.PollNotFoundException;
import com.votingsystem.api.exception.UnauthorizedActionException;
import com.votingsystem.api.repository.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;
import com.votingsystem.api.domain.poll.PollOption;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PollService {
    private final PollRepository pollRepository;

    public Poll createPoll(User user, PollRequestDto pollRequest) {
        Poll poll = new Poll();
        poll.setCreatedAt(LocalDateTime.now());
        poll.setOwner(user);
        return savePoll(poll, pollRequest);
    }

    public List<Poll> getTrends() {
        return pollRepository.findTop6ByTotalVotes();
    }

    public List<Poll> getByTitle(String title) {
        return pollRepository.findAllByTitleLikeIgnoreCase(title, Limit.of(10));
    }

    public List<Poll> getAllPolls() {
        return pollRepository.findAll();
    }

    public Poll getPollById(String id) {
        return findOrThrow(id);
    }

    public Poll updatePoll(User user, String id, PollRequestDto pollRequest) {
        Poll poll = findOrThrow(id);
        userIsAuthorized(user, poll);
        return savePoll(poll, pollRequest);
    }

    public Poll deletePoll(User user, String id)  {
        Poll poll = findOrThrow(id);
        userIsAuthorized(user, poll);
        pollRepository.delete(poll);
        return poll;
    }

    private Poll savePoll(Poll poll, PollRequestDto pollRequest) {
        poll.setTitle(pollRequest.title());
        poll.setDescription(pollRequest.description());
        poll.setOptions(mapOptions(pollRequest.options()));
        poll.setUpdatedAt(LocalDateTime.now());
        return pollRepository.save(poll);
    }

    private Poll findOrThrow(String id) {
        return pollRepository.findById(id)
                .orElseThrow(() -> new PollNotFoundException(id));
    }

    private List<PollOption> mapOptions(List<String> options) {
        return options.stream().map(PollOption::new).toList();
    }

    private void userIsAuthorized(User user, Poll poll) {
        if (!poll.getOwner().getId().equals(user.getId())) {
            throw new UnauthorizedActionException();
        }
    }
}