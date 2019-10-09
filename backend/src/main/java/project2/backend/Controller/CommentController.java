package project2.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project2.backend.Models.Comment;
import project2.backend.Repositories.CommentRepository;
import project2.backend.Repositories.PersonRepository;
import project2.backend.Services.CommentService;
import project2.backend.Services.PersonService;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    PersonService personService;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/list")
    public Iterable<Comment> listAllComments(){
        return commentService.listAllComments();
    }

    // request will look like
//    {
//        "comment" : "Big headed sweete boye!!",
//        "post" : {
//            "id" : 4
//        }
//    }
    @PostMapping("/create")
    public Comment createComment(@RequestBody Comment comment){

        return commentService.createComment(comment);
    }
    // should return something of form
//    {
//        "id": 2,
//            "comment": "Big headed sweete boye!!"
//    }

    // user should be able to delete their posts
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity deleteCommentById(@PathVariable Long commentId) {
        // Post post = postRepository.findById(postId).get();

        // TODO
        // get id of current user
        // get id of the comment author
        // compare
        // if match
        // commentService.deleteCommentById(commentId);
        // return new ResponseEntity(HttpStatus.OK);
        // else
        // return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);

        // placeholder
        return null;
    }
}
