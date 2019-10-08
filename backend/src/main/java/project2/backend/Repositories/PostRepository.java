package project2.backend.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project2.backend.Models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
