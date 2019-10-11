package project2.backend.Services;

import org.springframework.security.core.userdetails.UserDetailsService;
import project2.backend.Models.Post;
import project2.backend.Models.PostPersonObj;

import java.util.List;

public interface PostService {
    public Post createPost(Post newPost);
    public void deletePostById(Long postId);

    public List<PostPersonObj> listAllPosts();
    public Iterable<Post> findAllPostsByPerson(Long id);
}
