package project2.backend.Services;

import project2.backend.Models.Comment;

public interface CommentService {

    public Comment createComment (Comment comment);

    public Iterable<Comment> listComments();
}
