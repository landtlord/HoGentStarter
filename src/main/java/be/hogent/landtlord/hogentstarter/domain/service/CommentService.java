package be.hogent.landtlord.hogentstarter.domain.service;

import be.hogent.landtlord.hogentstarter.domain.bussines.Comment;
import be.hogent.landtlord.hogentstarter.domain.bussines.repository.CommentRepository;
import be.hogent.landtlord.hogentstarter.domain.service.dto.CommentDTO;
import be.hogent.landtlord.hogentstarter.domain.service.mappers.Mapper;

import javax.inject.Inject;

public class CommentService {
    @Inject
    private CommentRepository commentRepository;

    @Inject
    private Mapper<Comment, CommentDTO> commentMapper;

    public CommentDTO addComment(CommentDTO commentDTO) {
        Comment comment = commentMapper.toObject(commentDTO);
        comment = commentRepository.save(comment);
        return commentMapper.toDTO(comment);
    }
}
