package project2.backend.Services;

import project2.backend.Models.PersonRole;

public interface PersonRoleService {
    // create a new role
    public PersonRole createRole(PersonRole newRole);

    // get role
    public PersonRole getRole(String roleName);
}
