
package project2.backend.Controller;

import project2.backend.Config.JwtUtil;
import project2.backend.Services.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class) // tells JUnit to run using Spring's testing support
@WebMvcTest(PersonController.class) //autoconfiguration of Spring MVC and MockMmvc
public class PersonControllerTest {

    /**
     * Main entry point for server-side Spring MVC test support.
     **/
    @Autowired
    private MockMvc mockMvc;

    @MockBean  //to add mock objects to the Spring application context
    private PersonService personService;

    @MockBean
    private JwtUtil jwtUtil;

    @Test
    public void helloWorld_ReturnsString_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders  //Mocks the 'get' request using 'hello'
                .get("/hello")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!!"));
    }

    @Test
    public void login_Success() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/login") // make an HTTP request to a /login API
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserInJson("joe", "abc"));

        when(personService.login(any())).thenReturn("123456");  //mock the call to login() method in UserService class

        MvcResult result = mockMvc.perform(requestBuilder)  //call our requestBuilder and verify the response we get:
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"123456\"}"))
                .andReturn();  // stores the response we get after executing the requestBuilder

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void signUp_Success() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createUserInJson("joe", "abc"));

        when(personService.createPerson(any())).thenReturn("123456");

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"123456\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    private static String createUserInJson(String name, String password) {  //convert username and password to a JSON format string,
        return "{ \"username\": \"" + name + "\", " +
                "\"password\":\"" + password + "\"}";
    }
}