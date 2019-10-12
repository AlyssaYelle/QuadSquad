package project2.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import project2.backend.Models.JwtResponse;
import project2.backend.Models.Person;
import project2.backend.Services.PersonService;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Person person) {
        return ResponseEntity.ok(new JwtResponse(personService.login(person)));
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user/list")
    public Iterable<Person> listPeople() {
        return personService.listPeople();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> createPerson(@RequestBody Person newPerson) {
        System.out.println("We Are Here sign up endpoint");
        return ResponseEntity.ok(new JwtResponse(personService.createPerson(newPerson)));
    }

    @DeleteMapping("/user/{userId}")
    public HttpStatus deleteUserById(@PathVariable Long userId) {
        return personService.deleteById(userId);
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!!";
    }

    @GetMapping("/person/{username}")
    public Person getPersonInfo(@PathVariable String username) {
        return personService.getPerson(username);
    }
}
