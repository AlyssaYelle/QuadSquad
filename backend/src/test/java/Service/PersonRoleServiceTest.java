package Service;

import project2.backend.Models.PersonRole;
import project2.backend.Repositories.PersonRoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import project2.backend.Services.PersonRoleServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)

public class PersonRoleServiceTest {

    @Mock
    private PersonRoleRepository personRoleRepository;

    @InjectMocks
    private PersonRoleServiceImpl personRoleServiceImpl;

    @InjectMocks
    private PersonRole personRole;

    public PersonRoleServiceTest() {
    }

    @Before
    public void initDummyUserRole() {
        personRole.setName("ROLE_ADMIN");
    }

    @Test
    public void getPersonRole_ReturnsUser_Success() {

        when(personRoleRepository.findByName(anyString())).thenReturn(personRole);

        PersonRole tempUser = personRoleServiceImpl.getRole(personRole.getName());

        assertEquals(tempUser.getName(), personRole.getName());
    }
}
