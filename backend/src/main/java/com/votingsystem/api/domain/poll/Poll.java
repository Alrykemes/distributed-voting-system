package com.votingsystem.api.domain.poll;

import com.votingsystem.api.domain.user.UserPoll;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "polls")
public class Poll {
    @Id()
    private String id;
    private String title;
    private String description;
    private UserPoll owner;
    private Long positiveNumberOfVotes;
    private Long negativeNumberOfVotes;
}
