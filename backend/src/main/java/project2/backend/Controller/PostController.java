package project2.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import project2.backend.Config.JwtUtil;
import project2.backend.Models.Person;
import project2.backend.Models.Post;
import project2.backend.Repositories.PersonRepository;
import project2.backend.Repositories.PostRepository;
import project2.backend.Services.PersonService;
import project2.backend.Services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    JwtUtil jwtUtil;

//    @GetMapping("/list")
//    public Iterable<Post> listAllPosts(){
//        return postService.listAllPosts();
//    }

    // a logged in user should be able to create a post
//    {
//        "title" : "a title",
//        "content" : "some content"
//    }
    @PostMapping("/create")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }
    // response looks like:
//    {
//        "id": 4,
//            "title": "Garry",
//            "content": "Garry is 80lbs of sweetness topped with a BIG precious head."
//    }

    // user should be able to delete their posts
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity deletePostById(@PathVariable Long postId) {
        // Post post = postRepository.findById(postId).get();

        // get id of current user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String personName = authentication.getName();
        Long personId = personService.getPerson(personName).getId();

        // Grab the id of the person associated with target post
        Long associatedId = postRepository.findById(postId).get().getPerson().getId();

        // Compare
        if(personId == associatedId){
            postService.deletePostById(postId);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/list/{personId}")
    public Iterable<Post> listAllPostsFromPerson(@PathVariable Long personId){
        return postService.findAllPostsByPerson(personId);
    }
}
