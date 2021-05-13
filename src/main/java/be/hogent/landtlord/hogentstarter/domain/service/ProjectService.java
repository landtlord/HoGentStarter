package be.hogent.landtlord.hogentstarter.domain.service;

import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.ProjectRepository;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.Mapper;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.ProjectMapper;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.UserMapper;
import be.hogent.landtlord.hogentstarter.persistence.repository.ProjectRepositoryImpl;

import javax.inject.Named;
import java.util.List;

@Named()
public class ProjectService {
    private ProjectRepository projectRepository;

    private Mapper<Project, ProjectDTO> projectMapper;

    private Mapper<User, UserDTO> userMapper;

    public ProjectService() {
        System.out.println("projectservice initiated");
        projectRepository = new ProjectRepositoryImpl();
        projectMapper = new ProjectMapper();
        userMapper = new UserMapper();
    }

    public List<ProjectDTO> getAllRunningProjects() {
        List<Project> projects = projectRepository.findAllRunningProjects();
        return projectMapper.toDTO(projects);
    }

    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAllProjects();
        return projectMapper.toDTO(projects);
    }

    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = projectMapper.toObject(projectDTO);
        project = projectRepository.save(project);
        return projectMapper.toDTO(project);
    }

    public ProjectDTO changeProject(ProjectDTO projectDTO) {
        Project project = projectMapper.toObject(projectDTO);
        project = projectRepository.update(project);
        return projectMapper.toDTO(project);
    }

    public ProjectDTO deleteProject(ProjectDTO projectDTO) {
        Project project = projectRepository.findById(projectDTO.getId());
        project.delete();
        project = projectRepository.update(project);
        return projectMapper.toDTO(project);
    }

    public ProjectDTO closeProject(ProjectDTO projectDTO) {
        Project project = projectRepository.findById(projectDTO.getId());
        project.close();
        project = projectRepository.update(project);
        return projectMapper.toDTO(project);
    }

    public List<ProjectDTO> getAllProjectsOwnedBy(UserDTO userDTO){
        User user = userMapper.toObject(userDTO);
        List <Project> projects = projectRepository.findAllProjectsOwnedBy(user);
        return projectMapper.toDTO(projects);
    }
}
