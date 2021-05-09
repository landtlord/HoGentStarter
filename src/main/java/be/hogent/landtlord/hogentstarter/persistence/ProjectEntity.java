package be.hogent.landtlord.hogentstarter.persistence;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class ProjectEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double neededFunds;
    @OneToMany
    private List<FundsEntity> raisedFunds;

    @ManyToOne
    private UserEntity owner;

}
