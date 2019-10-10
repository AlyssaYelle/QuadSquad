package project2.backend.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.backend.Models.Comment;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query("FROM Comment c WHERE c.person.id = ?1")
    public Iterable<Comment> listCommentsByPerson(Long id);
}
