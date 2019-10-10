package project2.backend.Controller;

import Service.PostServiceStub;
import org.junit.Before;
import org.junit.Test;

public class PostControllerTest {

    private PostController postController;

    @Before
    public void initializePostController(){
        postController = new PostController();
        postController.setPostService(new PostServiceStub());
    }

    @Test
    public void createPost_SavePost_Success(){
        Post post = new Post();
        post.title("batman");

        Post newPost = postController.createPost("batman", post);

        Assert.assertNotNull(newPost);
        Assert.assertEquals(newPost.getTitle(), post.getTitle());
    }
}
