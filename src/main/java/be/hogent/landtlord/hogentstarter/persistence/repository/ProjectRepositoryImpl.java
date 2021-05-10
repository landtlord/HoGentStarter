package be.hogent.landtlord.hogentstarter.persistence.repository;

import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.ProjectRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository{
    private static final String NAME_PERSISTENCE_UNIT = "HoGentStarter";

    private EntityManagerFactory entityManagerFactory;


    public ProjectRepositoryImpl() {
        System.out.println("ProjectRepositoryImpl created");
        entityManagerFactory = Persistence.createEntityManagerFactory(NAME_PERSISTENCE_UNIT);
    }

    @Override
    public List<Project> findAllProjects() {
        return null;
    }

    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public Project update(Project project) {
        return null;
    }

    @Override
    public List<Project> findAllProjectsOwnedBy(User user) {
        return null;
    }

    @Override
    public Project findById(Long projectId) {
        return null;
    }
}
