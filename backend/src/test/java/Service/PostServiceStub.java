package Service;

import project2.backend.Models.Post;

public class PostServiceStub implements PostService {

    @Override
    public Post createPost(Post newPost) {
        return null;
    }

    @Override
    public Post getPost(post) {
        return null;
    }

    @Override
    public Post createPost(post, newPost) {
        Post post = new Post();
        post.setTitle("batman");

        return post;
    }
}