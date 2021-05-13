package be.hogent.landtlord.hogentstarter.persistence;

import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
public class CommentEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ProjectEntity projectEntity;

    @ManyToOne
    private UserEntity userEntity;

    private String title;
    private String comment;
    private LocalDate commentTime;
}
