package com.votingsystem.api.controller;


import com.votingsystem.api.domain.poll.Poll;
import com.votingsystem.api.domain.poll.PollRequestDto;
import com.votingsystem.api.domain.poll.PollResponseDto;
import com.votingsystem.api.domain.user.User;
import com.votingsystem.api.services.PollService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/polls")
@RequiredArgsConstructor
public class PollController {
    private final PollService service;

    @PostMapping()
    public ResponseEntity<PollResponseDto> createPoll(
            Authentication authentication,
            @RequestBody @Valid PollRequestDto createRequest
    ) {
        User user = (User) authentication.getPrincipal();
        Poll poll = service.createPoll(user, createRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(poll.getId())
                .toUri();
        return ResponseEntity.created(location).body(new PollResponseDto(poll));
    }

    @GetMapping()
    public ResponseEntity<List<PollResponseDto>> getAll() {
        List<PollResponseDto> polls = service.getAllPolls().stream().map(PollResponseDto::new).toList();
        return ResponseEntity.ok(polls);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PollResponseDto> get(@PathVariable String id) {
        return ResponseEntity.ok(new PollResponseDto(service.getPollById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PollResponseDto> update(
            Authentication authentication,
            @PathVariable String id,
            @RequestBody @Valid PollRequestDto updateRequest) {
        User user = (User) authentication.getPrincipal();
        Poll poll = service.updatePoll(user, id, updateRequest);
        return ResponseEntity.ok(new PollResponseDto(poll));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<PollResponseDto> delete(
            Authentication authentication,
            @PathVariable String id
    ) {
        User user = (User) authentication.getPrincipal();
        Poll deletedPoll = service.deletePoll(user, id);
        return ResponseEntity.ok(new PollResponseDto(deletedPoll));
    }
}