package project2.backend.Services;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import project2.backend.Models.Post;
import project2.backend.Repositories.PostRepository;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;

    @Override
    public Post createPost(Post newPost) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return postRepository.save(newPost);
    }

    @Override
    public Post deletePost(Post post) {
        return null;
    }
}
