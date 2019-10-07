package project2.backend.Services;


import project2.backend.Models.PersonProfile;

public interface PersonProfileService {

    // want to create a profile
    public PersonProfile createPersonProfile(String username, PersonProfile newProfile);

    // and also view profile contents
    public PersonProfile getUserProfile(String username);
}
