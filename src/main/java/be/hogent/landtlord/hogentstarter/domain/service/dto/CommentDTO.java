package be.hogent.landtlord.hogentstarter.domain.service.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentDTO {
    private Long id;
    private String title;
    private String comment;
    private ProjectDTO projectDTO;
    private UserDTO userDTO;
    private LocalDate commentTime;
}
