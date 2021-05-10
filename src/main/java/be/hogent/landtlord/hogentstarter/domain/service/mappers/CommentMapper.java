package be.hogent.landtlord.hogentstarter.domain.service.mappers;

import be.hogent.landtlord.hogentstarter.domain.bussines.Comment;
import be.hogent.landtlord.hogentstarter.domain.service.dto.CommentDTO;

import static java.util.Objects.isNull;

public class CommentMapper implements Mapper<Comment, CommentDTO> {
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

        return commentDTO;
    }
}
