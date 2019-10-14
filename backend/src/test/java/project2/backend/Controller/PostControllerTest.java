package project2.backend.Controller;

import project2.backend.Models.Post;
import Service.PostServiceStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostControllerTest {

    private PostController postController;

    @Before
    public void initializePostController() {
        postController = new PostController();
        postController.setPostService(new PostServiceStub());
    }

    @Test
    public void createPost_SavePost_Success() {
        Post post = new Post();
        post.setContent("Let's test this post");

        Post newPost = postController.createPost(post);
        Assert.assertNotNull(newPost.getContent());
        Assert.assertEquals(newPost.getContent(), post.getContent());
    }
}