package com.votingsystem.api.services;

import com.votingsystem.api.domain.poll.Poll;
import com.votingsystem.api.domain.poll.PollRequestDto;
import com.votingsystem.api.repository.PollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PollService {

  private final PollRepository repository;

  public PollService(PollRepository repository) {
    this.repository = repository;
  }

  public List<Poll> getAll() {
    return repository.findAll();
  }

  public Poll createPoll(PollRequestDto dto) {
    Poll poll = new Poll(); 
    poll.setTitle(dto.title());
    poll.setDescription(dto.description());
    poll.setOwner(dto.owner());
    poll.setOptions(dto.options());
    poll.setNumberOfVotes(0);
    return repository.save(poll);

  }

  public Poll getPollById(String id) {
    return repository.findById(id).orElse(null);
  }

  public Poll updatePoll(String id, PollRequestDto dto ) {
    Poll poll = repository.findById(id).orElse(null);
    if(poll != null) {
      poll.setTitle(dto.title());
      poll.setDescription(dto.description());
      poll.setOwner(dto.owner());
      poll.setOptions(dto.options());
      return repository.save(poll); 
    }
    return null;
  }

  public void delete(String id) {
    repository.deleteById(id);
  }
}
