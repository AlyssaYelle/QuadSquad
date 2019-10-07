package project2.backend.Services;


import social.project2.Models.PersonProfile;

public interface PersonProfileService {

    // want to create a profile
    public PersonProfile createPersonProfile(String username, PersonProfile newProfile);

    // and also view profile contents
    public PersonProfile getUserProfile(String username);
}
