package be.hogent.landtlord.hogentstarter.persistence.repository;

import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.UserRepository;
import be.hogent.landtlord.hogentstarter.persistence.ProjectEntity;
import be.hogent.landtlord.hogentstarter.persistence.UserEntity;
import be.hogent.landtlord.hogentstarter.persistence.mappers.Mapper;
import be.hogent.landtlord.hogentstarter.persistence.mappers.UserMapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private EntityManagerFactory entityManagerFactory;

    private Mapper<User, UserEntity> userMapper;

    public UserRepositoryImpl() {
        entityManagerFactory = EntityManagerSingleton.getInstance().getEntityManagerFactory();
        userMapper = new UserMapper();
    }
    @Override
    public List<User> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<UserEntity> query = entityManager.createQuery("Select u from UserEntity u", UserEntity.class);
        List<UserEntity> userEntities = query.getResultList();
        entityManager.close();
        return userMapper.toObject(userEntities);
    }

    @Override
    public User save(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserEntity userEntity = userMapper.toEntity(user);
        persist(entityManager, userEntity);
        return userMapper.toObject(userEntity);
    }

    @Override
    public User update(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserEntity userEntity = entityManager.find(UserEntity.class, user.getId());
        userEntity.setRole(user.getRole());
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        persist(entityManager, userEntity);
        return userMapper.toObject(userEntity);
    }

    @Override
    public User findUserBy(String userName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<UserEntity> query = entityManager.createQuery("Select u from UserEntity u where u.userName = :userName ", UserEntity.class);
        query.setParameter("userName", userName);
        return userMapper.toObject(query.getSingleResult());
    }

    private void persist(EntityManager entityManager, UserEntity userEntity) {
        entityManager.getTransaction().begin();
        entityManager.persist(userEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
