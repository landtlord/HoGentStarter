package be.hogent.landtlord.hogentstarter.persistence;

import javax.persistence.*;

@Entity
public class FundsEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ProjectEntity projectEntity;

    @ManyToOne
    private UserEntity userEntity;
}
