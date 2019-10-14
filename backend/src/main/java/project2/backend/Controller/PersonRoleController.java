package project2.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project2.backend.Models.PersonRole;
import project2.backend.Services.PersonRoleService;

@RestController
@RequestMapping("/role")
public class PersonRoleController {
    @Autowired
    PersonRoleService roleService;

    @GetMapping("/{roleName}")
    public PersonRole getRole(@PathVariable String roleName) {
        return roleService.getRole(roleName);
    }

    @PostMapping("/createRole")
    public PersonRole createRole(@RequestBody PersonRole role) {
        return roleService.createRole(role);
    }
}
