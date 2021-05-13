package be.hogent.landtlord.hogentstarter.persistence.repository;

import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.ProjectRepository;
import be.hogent.landtlord.hogentstarter.persistence.ProjectEntity;
import be.hogent.landtlord.hogentstarter.persistence.UserEntity;
import be.hogent.landtlord.hogentstarter.persistence.mappers.Mapper;
import be.hogent.landtlord.hogentstarter.persistence.mappers.ProjectMapper;
import be.hogent.landtlord.hogentstarter.persistence.mappers.UserMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {
    private EntityManagerFactory entityManagerFactory;

    private Mapper<Project, ProjectEntity> projectMapper;

    private Mapper<User, UserEntity> userMapper;

    public ProjectRepositoryImpl() {
        entityManagerFactory = EntityManagerSingleton.getInstance().getEntityManagerFactory();
        projectMapper = new ProjectMapper();
        userMapper = new UserMapper();
    }

    @Override
    public List<Project> findAllProjects() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<ProjectEntity> query = entityManager.createQuery("Select p from ProjectEntity p", ProjectEntity.class);
        List<ProjectEntity> projectEntities = query.getResultList();
        entityManager.close();
        return projectMapper.toObject(projectEntities);
    }

    @Override
    public Project save(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectEntity projectEntity = projectMapper.toEntity(project);
        entityManager.getTransaction().begin();
        entityManager.persist(projectEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return projectMapper.toObject(projectEntity);
    }

    @Override
    public Project update(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectEntity projectEntityInDB = entityManager.find(ProjectEntity.class, project.getId());
        projectEntityInDB.setEndDate(project.getEndDate());
        projectEntityInDB.setDeleted(project.isDeleted());
        entityManager.getTransaction().begin();
        entityManager.persist(projectEntityInDB);
        entityManager.getTransaction().commit();
        entityManager.close();
        return projectMapper.toObject(projectEntityInDB);
    }

    @Override
    public List<Project> findAllProjectsOwnedBy(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserEntity userEntity = userMapper.toEntity(user);
        TypedQuery<ProjectEntity> query = entityManager.createQuery("Select p from ProjectEntity p where p.owner = :owner ", ProjectEntity.class);
        query.setParameter("owner", userEntity);
        List<ProjectEntity> projectEntities = query.getResultList();
        entityManager.close();
        return projectMapper.toObject(projectEntities);
    }

    @Override
    public Project findById(Long projectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectEntity projectEntity = entityManager.find(ProjectEntity.class, projectId);
        entityManager.close();
        return projectMapper.toObject(projectEntity);
    }
}
