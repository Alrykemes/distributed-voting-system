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


     public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }



}
