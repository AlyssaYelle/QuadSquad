package project2.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project2.backend.Models.PersonRole;
import project2.backend.Repositories.PersonRoleRepository;

@Service
public class PersonRoleServiceImpl implements PersonRoleService {
    @Autowired
    PersonRoleRepository personRoleRepository;

    @Override
    public PersonRole createRole(PersonRole newRole) {
        return personRoleRepository.save(newRole);
    }

    @Override
    public PersonRole getRole(String roleName) {
        return personRoleRepository.findByName(roleName);
    }
}
