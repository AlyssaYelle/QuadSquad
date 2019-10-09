package project2.backend.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Title of post
    @Column
    private String title;

    // Content of each post
    @Column
    private String content;

    // Creating relationship between posts and person - using OneToMany (annotation/bean(?))
    /* We are using CascadeType.ALL with the idea that when a user wants to delete their profile,
    they understand they are also removing all of their posts */
    // @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    // This will create a column that will link these two tables (can't be null).
//    @JoinColumn(name = "person_id", nullable = false)
//    private Person person;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "person_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Person person;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments;

    public Post(){};

    public void setPerson(Person person){
        this.person = person;
    }

    public Person getPerson(){
        return this.person;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }
}
