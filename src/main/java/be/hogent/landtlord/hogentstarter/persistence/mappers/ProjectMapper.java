package be.hogent.landtlord.hogentstarter.persistence.mappers;

import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;
import be.hogent.landtlord.hogentstarter.persistence.ProjectEntity;
import be.hogent.landtlord.hogentstarter.persistence.UserEntity;

import static java.util.Objects.isNull;

public class ProjectMapper implements Mapper<Project, ProjectEntity> {

    private Mapper<User, UserEntity> userMapper;

    public ProjectMapper() {
        userMapper = new UserMapper();
    }

    @Override
    public Project toObject(ProjectEntity projectEntity) {
        if (isNull(projectEntity)) {
            return null;
        }
        Project project = new Project();
        project.setId(projectEntity.getId());
        project.setTitle(projectEntity.getTitle());
        project.setDescription(projectEntity.getDescription());
        project.setStartDate(projectEntity.getStartDate());
        project.setEndDate(projectEntity.getEndDate());
        project.setNeededFunds(projectEntity.getNeededFunds());
        UserEntity ownerEntity = projectEntity.getOwner();
        User owner = userMapper.toObject(ownerEntity);
        project.setOwner(owner);

        return project;
    }

    @Override
    public ProjectEntity toEntity(Project project) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(project.getId());
        projectEntity.setTitle(project.getTitle());
        projectEntity.setDescription(project.getDescription());
        projectEntity.setStartDate(project.getStartDate());
        projectEntity.setEndDate(project.getEndDate());
        projectEntity.setNeededFunds(project.getNeededFunds());
        User owner = project.getOwner();
        UserEntity ownerEntity = userMapper.toEntity(owner);
        projectEntity.setOwner(ownerEntity);

        return projectEntity;
    }
}
