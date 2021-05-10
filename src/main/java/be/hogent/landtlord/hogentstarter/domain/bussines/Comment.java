package be.hogent.landtlord.hogentstarter.domain.bussines;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Comment {
    private Long id;
    private String title;
    private String comment;
    private Project project;
    private User user;
    private LocalDate commentTime;
}
