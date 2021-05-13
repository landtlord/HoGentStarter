package be.hogent.landtlord.hogentstarter.persistence.mappers;

import be.hogent.landtlord.hogentstarter.domain.bussines.Comment;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.persistence.CommentEntity;
import be.hogent.landtlord.hogentstarter.persistence.ProjectEntity;
import be.hogent.landtlord.hogentstarter.persistence.UserEntity;

public class CommentMapper implements Mapper<Comment, CommentEntity>{

    private Mapper<Project, ProjectEntity> projectMapper;

    private Mapper<User, UserEntity> userMapper;

    public CommentMapper() {
        projectMapper = new ProjectMapper();
        userMapper = new UserMapper();
    }

    @Override
    public Comment toObject(CommentEntity commentEntity) {
        Comment comment = new Comment();
        comment.setId(commentEntity.getId());
        comment.setTitle(commentEntity.getTitle());
        comment.setComment(commentEntity.getComment());
        comment.setCommentTime(commentEntity.getCommentTime());

        Project project = projectMapper.toObject(commentEntity.getProjectEntity());
        comment.setProject(project);

        User user = userMapper.toObject(commentEntity.getUserEntity());
        comment.setUser(user);

        return comment;
    }

    @Override
    public CommentEntity toEntity(Comment comment) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(comment.getId());
        commentEntity.setTitle(comment.getTitle());
        commentEntity.setComment(comment.getComment());
        commentEntity.setCommentTime(comment.getCommentTime());

        ProjectEntity project = projectMapper.toEntity(comment.getProject());
        commentEntity.setProjectEntity(project);

        UserEntity user = userMapper.toEntity(comment.getUser());
        commentEntity.setUserEntity(user);

        return commentEntity;
    }
}
