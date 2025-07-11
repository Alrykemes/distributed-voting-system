package com.votingsystem.api.domain.poll;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PollOption {
    private String id;
    private String text;
    private long votes;

    public PollOption(String text) {
        this.id = UUID.randomUUID().toString();
        this.text = text;
        this.votes = 0;
    }
}


