package project2.backend.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "person_profile")
public class PersonProfile {
    // unique primary key for person profile
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // person username
    @Column
    private String username;



    // 1-1 relationship with person table
    @JsonIgnore
    @OneToOne(mappedBy = "personProfile",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private Person person;

    public PersonProfile() {}

    // get Person

    public Person getPerson() {
        return person;
    }

    // set person

    public void setPerson(Person person) {
        this.person = person;
    }


    // column getters


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }


    // column setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
