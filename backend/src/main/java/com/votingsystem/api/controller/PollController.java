package com.votingsystem.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/polls")
public class PollController {

    @GetMapping("/")
    public String getPolls() {
        return "polls";
    }
}
