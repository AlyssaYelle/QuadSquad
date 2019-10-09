package project2.backend.Repositories;

import org.springframework.stereotype.Repository;
import project2.backend.Models.Comment;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
