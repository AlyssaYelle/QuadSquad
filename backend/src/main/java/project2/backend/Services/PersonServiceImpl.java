package project2.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project2.backend.Config.JwtUtil;
import project2.backend.Models.Person;
import project2.backend.Models.PersonRole;
import project2.backend.Repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    // tells Spring to look for and inject PersonRepository when PersonServiceImpl is created
    @Autowired
    PersonRepository personRepository;

    // tells Spring to look for and inject PersonRoleService
    @Autowired
    PersonRoleService personRoleService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    @Qualifier("encoder")
    PasswordEncoder bCryptPasswordEncoder;

    // find person by their username
    @Override
    public Person getPerson(String username) {
        return personRepository.findByUsername(username);
    }

    // list all people in person db
    @Override
    public Iterable<Person> listPeople() {
        return personRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = getPerson(username);

        if(person==null)
            throw new UsernameNotFoundException("User null");

        return new org.springframework.security.core.userdetails.User(person.getUsername(), bCryptPasswordEncoder.encode(person.getPassword()),
                true, true, true, true, getGrantedAuthorities(person));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Person person){
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(person.getPersonRole().getName()));

        return authorities;
    }

    // create a new person for sign up
    // string because it returns a token, not a person
    @Override
    public String createPerson(Person newPerson) {

        System.out.println("creating user");
        System.out.println(personRoleService);
        System.out.println(newPerson);
        System.out.println(newPerson.getPersonRole());
        System.out.println(newPerson.getPersonRole().getName());
        PersonRole personRole = personRoleService.getRole(newPerson.getPersonRole().getName());
        if (personRole == null) {
            System.out.println("null user role");
        }
        System.out.println(personRole);
        newPerson.setPersonRole(personRole);
        newPerson.setPassword(bCryptPasswordEncoder.encode(newPerson.getPassword()));
        System.out.println(newPerson.getPassword());
        System.out.println(newPerson.getUsername());
        if(personRepository.save(newPerson) != null){
            UserDetails userDetails = loadUserByUsername(newPerson.getUsername());
            return jwtUtil.generateToken(userDetails);
        }
        return null;

    }

    // log in existing person
    // also string because it returns a token
    // auth : no auth
    @Override
    public String login(Person person) {

        Person newPerson = personRepository.findByUsername(person.getUsername());
        //userRepository.login(user.getUsername(), user.getPassword()) != null
        if(newPerson != null && bCryptPasswordEncoder.matches(person.getPassword(), newPerson.getPassword())){
            UserDetails userDetails = loadUserByUsername(newPerson.getUsername());
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }

    // log out person
    @Override
    public HttpStatus deleteById(Long userId) {
        personRepository.deleteById(userId);
        return HttpStatus.OK;
    }


}
