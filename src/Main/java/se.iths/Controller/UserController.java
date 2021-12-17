package se.iths.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.iths.Repository.UserRepository;
import se.iths.entitys.UserEntity;
import se.iths.exceptions.NotFoundException;
import se.iths.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService){
        this.userRepository = userRepository;
        this.userService = userService;
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




}
