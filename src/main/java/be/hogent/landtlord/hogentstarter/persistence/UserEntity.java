package be.hogent.landtlord.hogentstarter.persistence;

import be.hogent.landtlord.hogentstarter.common.Role;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique=true)
    private String userName;
    private String password;
    @Enumerated
    private Role role;
    private boolean approved;
 }
