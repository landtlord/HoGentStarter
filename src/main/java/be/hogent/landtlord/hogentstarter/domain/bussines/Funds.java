package be.hogent.landtlord.hogentstarter.domain.bussines;

import lombok.Data;

@Data
public class Funds {
    private Long id;
    private Project project;
    private User user;
    private Double amount;
}
