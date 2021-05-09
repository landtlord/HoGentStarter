package be.hogent.landtlord.hogentstarter.domain.service;

import be.hogent.landtlord.hogentstarter.domain.service.dto.CommentDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.FundsDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;

import java.util.Collections;
import java.util.List;

public class ProjectService {
    public List<ProjectDTO> getAllProjects() {
        return Collections.emptyList();
    }

    public ProjectDTO createProject(ProjectDTO projectDTO) {
        return null;
    }

    public ProjectDTO changeProject(ProjectDTO projectDTO) {
        return null;
    }

    public ProjectDTO deleteProject(ProjectDTO projectDTO) {
        return null;
    }

    public List<FundsDTO> getFundsFor(Long projectId) {
        return Collections.emptyList();
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
