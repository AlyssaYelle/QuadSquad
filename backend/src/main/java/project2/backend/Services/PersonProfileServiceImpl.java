package project2.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import social.project2.Models.Person;
import social.project2.Models.PersonProfile;
import social.project2.Repositories.PersonProfileRepository;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {

    private PersonProfileRepository personProfileRepository;

    private PersonService personService;

    @Autowired
    public PersonProfileServiceImpl(PersonService personService, PersonProfileRepository personProfileRepository){
        this.personService = personService;
        this.personProfileRepository = personProfileRepository;
    }

    @Override
    public PersonProfile createPersonProfile(String username, PersonProfile newProfile) {
        Person person = personService.getPerson(username);
        newProfile.setPerson(person);
        return personProfileRepository.save(newProfile);
    }

    @Override
    public PersonProfile getUserProfile(String username) {
        return personProfileRepository.findProfileByUsername(username);
    }
}
