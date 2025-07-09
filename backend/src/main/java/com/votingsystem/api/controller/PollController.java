package com.votingsystem.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.votingsystem.api.domain.poll.Poll;
import com.votingsystem.api.domain.poll.PollRequestDto;
import com.votingsystem.api.services.PollService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller()
@RequestMapping("/polls")
public class PollController {

    private PollService service;

    public PollController(PollService service) {
        this.service = service; 
    }

    @GetMapping() 
    public List<Poll> getAllPolls() {
        return service.getAll();
    }

    @GetMapping("/{id}") 
    public Poll getPoll(@PathVariable String id) {
        return service.getPollById(id); 
    }

    @PostMapping
    public Poll createPoll(@RequestBody PollRequestDto dto) {
        return service.createPoll(dto); 
    }

    @PutMapping("{id}")
    public Poll updatePoll(@PathVariable String id, @RequestBody PollRequestDto dto) {
        return service.updatePoll(id, dto); 
    }
    
    @DeleteMapping("/{id}")
    public void deletePoll(@PathVariable String id) {
        service.delete(id); 
    }

    
}
