package Service;

import project2.backend.Models.Post;
import project2.backend.Models.PostPersonObj;
import project2.backend.Services.PostService;

import java.util.List;

public class PostServiceStub implements PostService {

    @Override
    public Post createPost(Post newPost) {
        Post post = new Post();
        post.setContent("Let's test this post");
        return post;
    }

    @Override
    public List<PostPersonObj> listAllPosts() {
        return null;
    }

    @Override
    public void deletePostById(Long postId){
    }

    @Override
    public Iterable<Post> findAllPostsByPerson(Long id){
        return null;

    }
}
