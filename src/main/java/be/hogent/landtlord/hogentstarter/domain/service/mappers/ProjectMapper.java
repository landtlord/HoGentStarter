package be.hogent.landtlord.hogentstarter.domain.service.mappers;

import be.hogent.landtlord.hogentstarter.domain.bussines.Funds;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.service.dto.FundsDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;

import java.util.List;

import static java.util.Objects.isNull;

public class ProjectMapper implements Mapper<Project, ProjectDTO> {
    private Mapper<Funds, FundsDTO> fundsMapper;

    private Mapper<User, UserDTO> userMapper;

    @Override
    public Project toObject(ProjectDTO projectDTO) {
        if (isNull(projectDTO)) {
            return null;
        }
        Project project = new Project();
        project.setId(projectDTO.getId());
        project.setTitle(projectDTO.getTitle());
        project.setDescription(projectDTO.getDescription());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());
        project.setNeededFunds(projectDTO.getNeededFunds());

        List<FundsDTO> raisedFundsDTO = projectDTO.getRaisedFunds();
        List<Funds> raisedFunds = fundsMapper.toObject(raisedFundsDTO);
        project.setRaisedFunds(raisedFunds);

        UserDTO ownerDTO = projectDTO.getOwner();
        User owner = userMapper.toObject(ownerDTO);
        project.setOwner(owner);

        return project;
    }

    @Override
    public ProjectDTO toDTO(Project project) {
        if (isNull(project)) {
            return null;
        }
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setTitle(project.getTitle());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setStartDate(project.getStartDate());
        projectDTO.setEndDate(project.getEndDate());
        projectDTO.setNeededFunds(project.getNeededFunds());

        List<Funds> raisedFunds = project.getRaisedFunds();
        List<FundsDTO> raisedFundsDTO = fundsMapper.toDTO(raisedFunds);
        projectDTO.setRaisedFunds(raisedFundsDTO);

        User owner = project.getOwner();
        UserDTO ownerDTO = userMapper.toDTO(owner);
        projectDTO.setOwner(ownerDTO);

        return projectDTO;
    }
}
