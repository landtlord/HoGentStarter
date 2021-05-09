package be.hogent.landtlord.hogentstarter.persistence;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "owner")
    private List<ProjectEntity> ownedProjects;

    @OneToMany(mappedBy = "userEntity")
    private List<FundsEntity> fundsEntities;
 }
