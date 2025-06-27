package com.votingsystem.api.domain.poll;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "polls")
public class Poll {
    @Id()
    private String id;
    private String title;
    private String description;
    private String owner;
    private String[] options;
    private int numberOfVotes;

}
