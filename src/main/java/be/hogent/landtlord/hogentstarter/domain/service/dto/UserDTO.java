package be.hogent.landtlord.hogentstarter.domain.service.dto;

import be.hogent.landtlord.hogentstarter.common.Role;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String userName;
    private String password;
    private Role role;
}
