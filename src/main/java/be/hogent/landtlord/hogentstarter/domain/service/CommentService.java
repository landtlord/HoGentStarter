package be.hogent.landtlord.hogentstarter.domain.service;

import be.hogent.landtlord.hogentstarter.domain.bussines.Comment;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.CommentRepository;
import be.hogent.landtlord.hogentstarter.domain.service.dto.CommentDTO;
import be.hogent.landtlord.hogentstarter.domain.service.dto.ProjectDTO;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.CommentMapper;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.Mapper;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.ProjectMapper;
import be.hogent.landtlord.hogentstarter.persistence.repository.CommentRepositoryImpl;

import javax.inject.Inject;
import java.util.List;

public class CommentService {
    private CommentRepository commentRepository;

    private Mapper<Comment, CommentDTO> commentMapper;

    private Mapper<Project, ProjectDTO> projectMapper;

    public CommentService() {
        this.commentRepository = new CommentRepositoryImpl();
        this.commentMapper = new CommentMapper();
        this.projectMapper = new ProjectMapper();
    }

    public CommentDTO addComment(CommentDTO commentDTO) {
        Comment comment = commentMapper.toObject(commentDTO);
        comment = commentRepository.save(comment);
        return commentMapper.toDTO(comment);
    }

    public List<CommentDTO> getCommentsFor(ProjectDTO projectDTO){
        Project project = projectMapper.toObject(projectDTO);
        List<Comment> comments = commentRepository.findCommentsFor(project);
        return commentMapper.toDTO(comments);
    }
}
