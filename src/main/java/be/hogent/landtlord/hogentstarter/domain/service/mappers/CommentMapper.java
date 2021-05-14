package be.hogent.landtlord.hogentstarter.domain.service.mappers;

import be.hogent.landtlord.hogentstarter.domain.bussines.Comment;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.User;
import be.hogent.landtlord.hogentstarter.domain.service.dto.CommentDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.UserDTO;

import static java.util.Objects.isNull;

public class CommentMapper implements Mapper<Comment, CommentDTO> {
    private Mapper<User, UserDTO> userMapper;

    private Mapper<Project, ProjectDTO> projectMapper;

    public CommentMapper() {
        userMapper = new UserMapper();
        projectMapper = new ProjectMapper();
    }

    @Override
    public Comment toObject(CommentDTO commentDTO) {
        if (isNull(commentDTO)){
            return null;
        }
        Comment comment = new Comment();

        comment.setId(commentDTO.getId());
        comment.setTitle(commentDTO.getTitle());
        comment.setComment(commentDTO.getComment());
        comment.setCommentTime(commentDTO.getCommentTime());

        UserDTO userDTO = commentDTO.getUserDTO();
        comment.setUser(userMapper.toObject(userDTO));

        ProjectDTO projectDTO = commentDTO.getProjectDTO();
        comment.setProject(projectMapper.toObject(projectDTO));

        return comment;
    }

    @Override
    public CommentDTO toDTO(Comment comment) {
        if (isNull(comment)){
            return null;
        }
        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setId(comment.getId());
        commentDTO.setTitle(comment.getTitle());
        commentDTO.setComment(comment.getComment());
        commentDTO.setCommentTime(comment.getCommentTime());

        User user = comment.getUser();
        commentDTO.setUserDTO(userMapper.toDTO(user));

        Project project = comment.getProject();
        commentDTO.setProjectDTO(projectMapper.toDTO(project));

        return commentDTO;
    }
}
