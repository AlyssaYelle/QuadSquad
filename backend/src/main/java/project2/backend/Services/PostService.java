package project2.backend.Services;

import org.springframework.security.core.userdetails.UserDetailsService;
import project2.backend.Models.Post;

public interface PostService {
    Post createPost(Post newPost);
    Post deletePost(Post post);
}
