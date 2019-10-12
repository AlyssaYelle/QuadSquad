package project2.backend.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project2.backend.Models.Post;
import project2.backend.Models.PostPersonObj;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("FROM Post p WHERE p.person.id= ?1")
    public Iterable<Post> findAllPostsByPerson(Long personId);

//    @Query("SELECT pe.username, p.id, p.content, p.title FROM person pe INNER JOIN post p ON p.person_id = pe.id")
//    public List<PostPersonObj> listPosts();

    @Query("SELECT new project2.backend.Models.PostPersonObj(pe.username, p.id, p.content, p.title)" +
            "FROM Post p INNER JOIN p.person pe")
    public List<PostPersonObj> listPosts();
}
