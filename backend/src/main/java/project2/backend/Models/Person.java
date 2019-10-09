package project2.backend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    // generate unique primary key
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // unique username
    @Column(unique = true)
    private String username;

    // password
    @Column
    private String password;

    // email address
    @Column
    private String email;

    // 1-1 relationship with personProfile table
    // joined on username
    // if a person is deleted from db, their profile should also be deleted
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_id")
    private PersonProfile personProfile;

    // get personProfile
    public PersonProfile getPersonProfile() {
        return personProfile;
    }

    // set personProfile

    public void setPersonProfile(PersonProfile personProfile) {
        this.personProfile = personProfile;
    }


    // link with PersonRole
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "person_role_id", nullable = false)
    private PersonRole personRole;

    // get person role
    public PersonRole getPersonRole() {
        return personRole;
    }

    // set person role
    public void setPersonRole(PersonRole personRole) {
        this.personRole = personRole;
    }

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Post> posts;

    @OneToMany(
            mappedBy = "person",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private List<Comment> comments;


    public Person(){};

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    // column getters

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


    // column setters


    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> addPost(Post post){
        if(posts == null){
            posts = new ArrayList<>();
        }
        posts.add(post);
        return posts;
    }

    public List<Comment> addComment(Comment comment){
        if (comment==null ){
            comments = new ArrayList<>();
        }
        comments.add(comment);

        return comments;
    }
}
