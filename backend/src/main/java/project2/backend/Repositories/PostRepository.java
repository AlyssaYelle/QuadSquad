package project2.backend.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project2.backend.Models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    @Query("FROM Post p WHERE p.person.id= ?1")
    public Iterable<Post> findAllPostsByPerson(Long personId);

    @Query("FROM Post po join Person pe ON po.person_id = pe.id")
    public Iterable<Post> listPosts();
}
