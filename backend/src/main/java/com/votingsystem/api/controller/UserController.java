package com.votingsystem.api.controller;

import com.votingsystem.api.domain.poll.Poll;
import com.votingsystem.api.domain.user.UserPoll;
import com.votingsystem.api.services.UserPollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserPollService userPollService;

    @DeleteMapping("/delete")
    public ResponseEntity<UserPoll> deleteUser(Authentication authentication) {
        try {
            UserPoll user = (UserPoll) authentication.getPrincipal();
            return ResponseEntity.ok(userPollService.delete(user));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete-all-polls")
    public ResponseEntity<List<Poll>> deleteAllPolls(Authentication authentication) {
        try {
            UserPoll user = (UserPoll) authentication.getPrincipal();
            return ResponseEntity.ok(userPollService.deletePolls(user));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
