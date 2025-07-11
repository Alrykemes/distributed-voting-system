package com.votingsystem.api.domain.poll;


import com.votingsystem.api.domain.user.User;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "polls")
public class Poll {
    @Id
    private String id;

    private User user;

    private String title;

    private String description;

    private List<PollOption> options;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
