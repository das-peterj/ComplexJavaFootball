package se.iths.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import se.iths.Repository.RoleRepository;
import se.iths.Repository.UserRepository;
import se.iths.entitys.RoleEntity;
import se.iths.entitys.UserEntity;
import se.iths.exceptions.NotFoundException;
import se.iths.services.UserService;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final RoleRepository roleRepository;

    public UserController(UserRepository userRepository, UserService userService, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @PostMapping("")
    @ResponseStatus(CREATED)
    public ResponseEntity <UserEntity>createUser( @RequestBody UserEntity userEntity) {
        UserEntity createdUser = userService.createUser(userEntity);
        return new ResponseEntity<>(createdUser, CREATED);
    }

    @GetMapping()
    public ResponseEntity<Iterable<UserEntity>> findAllUsers() {
        Iterable<UserEntity> allUsers = userService.findAllUsers();
        String errPlayersNotFound = "{\"Error\": \"No users found}";

        if(allUsers == null) {
            throw new NotFoundException(errPlayersNotFound);
        }
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/createAdmin/{userName}")
    @ResponseStatus(CREATED)
    public ResponseEntity<UserEntity> createAdmin(@PathVariable String userName) {
        RoleEntity roleToAdd = roleRepository.findByRole("ADMIN");
        UserEntity foundUser = userRepository.findByUserName(userName);
        foundUser.addRole(roleToAdd);
        userRepository.save(foundUser);
        return new ResponseEntity<>(foundUser, HttpStatus.OK);
    }
}
