package be.hogent.landtlord.hogentstarter.domain.bussines;

import be.hogent.landtlord.hogentstarter.common.Role;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String userName;
    private String password;
    private Role role;
}
