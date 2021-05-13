package be.hogent.landtlord.hogentstarter.domain.service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProjectDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double neededFunds;
    private UserDTO owner;
}
