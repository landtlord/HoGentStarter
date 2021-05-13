package be.hogent.landtlord.hogentstarter.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Data
public class ProjectEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double neededFunds;
    private boolean deleted;

    @ManyToOne
    private UserEntity owner;

}
