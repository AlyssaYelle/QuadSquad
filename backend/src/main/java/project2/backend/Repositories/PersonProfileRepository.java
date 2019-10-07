package project2.backend.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import project2.backend.Models.PersonProfile;

public interface PersonProfileRepository extends CrudRepository<PersonProfile, Long> {
    // find a profile by person's username
    @Query("from PersonProfile pp left join Person p on p.username = ?1 and pp.id = p.personProfile.id")
    public PersonProfile findProfileByUsername(String username);

}
