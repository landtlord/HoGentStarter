package be.hogent.landtlord.hogentstarter.persistence;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FundsEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ProjectEntity projectEntity;

    @ManyToOne
    private UserEntity userEntity;

    private Double amount;
}
