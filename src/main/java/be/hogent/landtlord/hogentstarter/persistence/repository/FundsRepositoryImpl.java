package be.hogent.landtlord.hogentstarter.persistence.repository;

import be.hogent.landtlord.hogentstarter.domain.bussines.Funds;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.FundsRepository;
import be.hogent.landtlord.hogentstarter.persistence.FundsEntity;
import be.hogent.landtlord.hogentstarter.persistence.ProjectEntity;
import be.hogent.landtlord.hogentstarter.persistence.UserEntity;
import be.hogent.landtlord.hogentstarter.persistence.mappers.FundsMapper;
import be.hogent.landtlord.hogentstarter.persistence.mappers.Mapper;
import be.hogent.landtlord.hogentstarter.persistence.mappers.ProjectMapper;
import be.hogent.landtlord.hogentstarter.persistence.mappers.UserMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class FundsRepositoryImpl implements FundsRepository {
    private EntityManagerFactory entityManagerFactory;

    private Mapper<Funds, FundsEntity> fundsMapper;

    private Mapper<User, UserEntity> userMapper;

    private Mapper<Project, ProjectEntity> projectMapper;

    public FundsRepositoryImpl() {
        entityManagerFactory = EntityManagerSingleton.getInstance().getEntityManagerFactory();
        fundsMapper = new FundsMapper();
        userMapper = new UserMapper();
        projectMapper = new ProjectMapper();
    }

    @Override
    public Funds save(Funds funds) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        FundsEntity fundsEntity = fundsMapper.toEntity(funds);
        entityManager.getTransaction().begin();
        entityManager.persist(fundsEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return fundsMapper.toObject(fundsEntity);
    }

    @Override
    public List<Funds> findFundsFor(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectEntity projectEntity = projectMapper.toEntity(project);
        TypedQuery<FundsEntity> query = entityManager.createQuery("Select f from FundsEntity f where f.projectEntity = :projectEntity ", FundsEntity.class);
        query.setParameter("projectEntity", projectEntity);
        List<FundsEntity> fundsEntities = query.getResultList();
        entityManager.close();
        return fundsMapper.toObject(fundsEntities);
    }

    @Override
    public List<Funds> findFundsFor(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserEntity userEntity = userMapper.toEntity(user);
        TypedQuery<FundsEntity> query = entityManager.createQuery("Select f from FundsEntity f where f.userEntity = :userEntity ", FundsEntity.class);
        query.setParameter("userEntity", userEntity);
        List<FundsEntity> fundsEntities = query.getResultList();
        entityManager.close();
        return fundsMapper.toObject(fundsEntities);
    }
}
