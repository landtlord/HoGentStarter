package be.hogent.landtlord.hogentstarter.domain.bussines;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Project {
    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double neededFunds;
    private User owner;
    private boolean deleted = false;

    public void delete() {
        deleted = true;
    }

    public void close(){
        endDate = LocalDate.now();
    }
}
