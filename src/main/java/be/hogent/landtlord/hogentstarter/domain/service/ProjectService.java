package be.hogent.landtlord.hogentstarter.domain.service;

import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.ProjectRepository;
import be.hogent.landtlord.hogentstarter.domain.service.dto.CommentDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.FundsDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.Mapper;

import java.util.List;

public class ProjectService {
    private ProjectRepository projectRepository;

    private Mapper<Project, ProjectDTO> projectMapper;

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
        return null;
    }

    public List<FundsDTO> getFundsFor(Long projectId) {
        Project project = projectRepository.findById(projectId);
        ProjectDTO projectDTO = projectMapper.toDTO(project);
        return projectDTO.getRaisedFunds();
    }

    public ProjectDTO addComment(Long projectId, CommentDTO commentDTO) {
        return null;
    }

    public ProjectDTO closeProject(Long projectId) {
        return null;
    }

    public FundsDTO addFunds(FundsDTO fundsDTO) {
        return null;
    }
}
