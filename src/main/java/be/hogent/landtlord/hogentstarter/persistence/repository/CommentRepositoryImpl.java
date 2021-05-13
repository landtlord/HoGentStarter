package be.hogent.landtlord.hogentstarter.persistence.repository;

import be.hogent.landtlord.hogentstarter.domain.bussines.Comment;
import be.hogent.landtlord.hogentstarter.domain.bussines.Funds;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.CommentRepository;
import be.hogent.landtlord.hogentstarter.persistence.CommentEntity;
import be.hogent.landtlord.hogentstarter.persistence.FundsEntity;
import be.hogent.landtlord.hogentstarter.persistence.ProjectEntity;
import be.hogent.landtlord.hogentstarter.persistence.UserEntity;
import be.hogent.landtlord.hogentstarter.persistence.mappers.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {
    private EntityManagerFactory entityManagerFactory;

    private Mapper<Comment, CommentEntity> commentMapper;


    private Mapper<Project, ProjectEntity> projectMapper;

    public CommentRepositoryImpl() {
        entityManagerFactory = EntityManagerSingleton.getInstance().getEntityManagerFactory();
        commentMapper = new CommentMapper();
        projectMapper = new ProjectMapper();
    }
    @Override
    public Comment save(Comment comment) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CommentEntity commentEntity = commentMapper.toEntity(comment);
        entityManager.getTransaction().begin();
        entityManager.persist(commentEntity);
        entityManager.getTransaction().commit();
        entityManager.close();
        return commentMapper.toObject(commentEntity);
    }

    @Override
    public List<Comment> findCommentsFor(Project project) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ProjectEntity projectEntity = projectMapper.toEntity(project);
        TypedQuery<CommentEntity> query = entityManager.createQuery("Select c from CommentEntity c where c.projectEntity = :project ", CommentEntity.class);
        query.setParameter("project", projectEntity);
        List<CommentEntity> commentEntities = query.getResultList();
        entityManager.close();
        return commentMapper.toObject(commentEntities);
    }
}
