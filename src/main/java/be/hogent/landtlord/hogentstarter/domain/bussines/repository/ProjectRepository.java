package be.hogent.landtlord.hogentstarter.domain.bussines.repository;

import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;

import java.util.List;

public interface ProjectRepository {
    List<Project> findAllProjects();

    Project save(Project project);

    Project update(Project project);

    Project findById(Long projectId);
}
