package be.hogent.landtlord.hogentstarter.domain.bussines.repository;

import be.hogent.landtlord.hogentstarter.domain.bussines.Comment;

public interface CommentRepository {
    Comment save(Comment comment);
}
