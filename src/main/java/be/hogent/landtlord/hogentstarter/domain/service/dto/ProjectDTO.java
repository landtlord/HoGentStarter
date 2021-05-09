package be.hogent.landtlord.hogentstarter.domain.service.dto;

import be.hogent.landtlord.hogentstarter.domain.bussines.Funds;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;

import java.time.LocalDate;
import java.util.List;

public class ProjectDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double neededFunds;
    private List<FundsDTO> raisedFunds;
    private UserDTO owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getNeededFunds() {
        return neededFunds;
    }

    public void setNeededFunds(double neededFunds) {
        this.neededFunds = neededFunds;
    }

    public List<FundsDTO> getRaisedFunds() {
        return raisedFunds;
    }

    public void setRaisedFunds(List<FundsDTO> raisedFunds) {
        this.raisedFunds = raisedFunds;
    }

    public UserDTO getOwner() {
        return owner;
    }

    public void setOwner(UserDTO owner) {
        this.owner = owner;
    }
}
