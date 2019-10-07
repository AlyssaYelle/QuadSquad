package project2.backend.Services;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import project2.backend.Models.Person;

public interface PersonService extends UserDetailsService {
    // need to be able to get a person's info by their unique username
    public Person getPerson(String username);

    // need to list all people
    public Iterable<Person> listPeople();

    // create a new person when someone signs up
    public String createPerson(Person newPerson);

    // a person must be able to log in
    public String login(Person person);

    // option to delete account
    public HttpStatus deleteById(Long userId);

}
