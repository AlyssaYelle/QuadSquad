package project2.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import project2.backend.Models.Comment;
import project2.backend.Repositories.CommentRepository;

public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Iterable<Comment> listComments(){
        return commentRepository.findAll();
    }
}