package Service;

import project2.backend.Config.JwtUtil;
import project2.backend.Models.Person;
import project2.backend.Repositories.PostRepository;
import project2.backend.Repositories.CommentRepository;
import project2.backend.Repositories.PersonRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import project2.backend.Services.CommentService;
import project2.backend.Services.PersonServiceImpl;
import project2.backend.Services.PostService;

import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)  // The JUnit Runner causes all the initialization
                                    // with @Mock and @InjectMocks to happen before the tests are run.
public class PersonServiceTest {

    @Mock  //to mock a class or interface
    PersonRepository personRepository;

    @InjectMocks  // to mock the PersonServiceImpl so we can use its methods
    private PersonServiceImpl personService;

    @Mock
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Mock
    private CommentService commentService;

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private Person person;

    public PersonServiceTest() {
    }

    @Before
    public void initializeDummyUser(){
        person.setUsername("batman");
        person.setPassword("robin");
    }

    @Test
    public void getUser_ReturnsUser_Success(){  //Test the getUser method

        when(personRepository.findByUsername(anyString())).thenReturn(person);  //mocks call to personRepository

        Person tempUser = personService.getPerson(person.getUsername());

        assertEquals(tempUser.getUsername(), person.getUsername());
    }

    @Test
    public void login_UserNotFound_Error(){  //tests the login method if user is not found

        when(personRepository.findByUsername(anyString())).thenReturn(null);

        String token = personService.login(person);

        assertNull(token);
    }
}