package be.hogent.landtlord.hogentstarter.domain.service.dto;

import lombok.Data;

@Data
public class FundsDTO {
    private Long id;
    private ProjectDTO projectDTO;
    private UserDTO userDTO;
    private Double amount;
}
