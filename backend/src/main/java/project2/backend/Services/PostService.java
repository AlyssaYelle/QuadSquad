package project2.backend.Services;

import org.springframework.security.core.userdetails.UserDetailsService;
import project2.backend.Models.Post;

public interface PostService {
    public Post createPost(Post newPost);
    public void deletePostById(Long postId);
    public Iterable<Post> listAllPosts();
}
