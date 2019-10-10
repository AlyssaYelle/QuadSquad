package project2.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import project2.backend.Models.Comment;
import project2.backend.Models.Person;
import project2.backend.Models.Post;
import project2.backend.Repositories.CommentRepository;
import project2.backend.Repositories.PersonRepository;
import project2.backend.Repositories.PostRepository;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @Autowired
    PostRepository postRepository;

    @Override
    public Iterable<Comment> listAllComments(){
        return commentRepository.findAll();
    }

    @Override
    public Comment createComment(Comment comment){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // gets the name of current authenticated user
        String currentPrincipalName = authentication.getName();

        System.out.println("creating comment");
        System.out.println(currentPrincipalName);

        // creates the person object that matches logged in user
        Person person = personService.getPerson(currentPrincipalName);


        System.out.println("person object : " + person);
        System.out.println("comment object: " + comment);

        // now we can set the poster of the comment
        comment.setPerson(person);

        // We need to set the comment to the post (using postId argument)
//        Post targetPost = postRepository.findById(postId);

        // and add the comment to the list of person's comments
        person.addComment(comment);

        // and finally save to db
        return commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Long commentId){
        Comment comment = commentRepository.findById(commentId).get();
        Person person = personRepository.findById(comment.getPerson().getId()).get();
        person.getComments().remove(comment);
        commentRepository.delete(comment);
    }

    @Override
    public Iterable<Comment> listCommentsByPerson(Long id){
        return commentRepository.listCommentsByPerson(id);
    }
}