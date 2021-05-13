package be.hogent.landtlord.hogentstarter.domain.bussines.repository;

import be.hogent.landtlord.hogentstarter.domain.bussines.Comment;
import be.hogent.landtlord.hogentstarter.domain.bussines.Project;

import java.util.List;

public interface CommentRepository {
    Comment save(Comment comment);

    List<Comment> findCommentsFor(Project project);
}
