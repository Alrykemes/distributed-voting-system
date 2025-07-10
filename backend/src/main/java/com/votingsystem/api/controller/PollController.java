package com.votingsystem.api.controller;

import com.votingsystem.api.domain.user.UserPoll;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.votingsystem.api.domain.poll.Poll;
import com.votingsystem.api.domain.poll.PollRequestDto;
import com.votingsystem.api.services.PollService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller()
@RequestMapping("/polls")
@RequiredArgsConstructor
public class PollController {

    private final PollService service;

    @GetMapping()
    public ResponseEntity<List<Poll>> getAllPolls() {
        try {
            List<Poll> polls = service.getAll();
            return ResponseEntity.ok(polls);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable String id) {
        try {
            Poll poll = service.getPollById(id);
            return ResponseEntity.ok(poll);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Poll> createPoll(Authentication authentication, @RequestBody PollRequestDto dto) {
        try {
            UserPoll user = (UserPoll) authentication.getPrincipal();
            Poll poll = service.createPoll(dto, user);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(poll.getId())
                    .toUri();
            return ResponseEntity.created(location).body(poll);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Poll> updatePoll(Authentication authentication, @PathVariable String id, @RequestBody PollRequestDto dto) {
        try {
            UserPoll user = (UserPoll) authentication.getPrincipal();
            Poll poll = service.updatePoll(id, dto, user);
            return ResponseEntity.ok(poll);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Poll> deletePoll(@PathVariable String id) {
        try {
            Poll poll = service.delete(id);
            return ResponseEntity.ok(poll);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}