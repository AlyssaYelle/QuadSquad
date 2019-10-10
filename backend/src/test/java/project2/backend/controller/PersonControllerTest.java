package project2.backend.controller;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import project2.backend.Config.JwtUtil;
import project2.backend.Controller.PersonController;
import project2.backend.Services.PersonService;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {
    /** Main entry point for server-side Spring MVC test support. **/
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @MockBean
    private JwtUtil jwtUtil;

    @Test
    public void helloWorld_ReturnsString_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/hello")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!!"));
    }

    @Test
    public void login_Returns200_Success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createPersonInJson("batman", "robin"));

        //Here we are mocking our call, login(), from personService
        /* We are saying when the control reaches personService.login(), a String
         is returned -> "123456" */
        when(personService.login(any())).thenReturn("123456");

        //Here we are calling our requestBuilder and verifying our response
        /*mockMvc.perform(requestBuilder)
                .andExpect(status().isOk());*/

        // Altered code from above ^. Below we are setting this up to store our response
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"123456\"}"))
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    private static String createPersonInJson(String username, String password) {
        return "{ \"username\": \"" + username + "\", " +
                "\"password\":\"" + password + "\"}";
    }
}
