package project2.backend.Repositories;

import org.springframework.data.repository.CrudRepository;
import project2.backend.Models.PersonRole;

public interface PersonRoleRepository extends CrudRepository<PersonRole, Integer> {

    public PersonRole findByName(String name);
}
