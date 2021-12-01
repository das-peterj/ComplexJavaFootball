package se.iths.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.entitys.ManagerEntity;
import se.iths.exceptions.NotFoundException;
import se.iths.services.ManagerService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService){
        this.managerService = managerService;
    }

    @PostMapping("")
    public ResponseEntity<ManagerEntity> createManager(@RequestBody ManagerEntity manager){
        ManagerEntity createdManager = managerService.createManager(manager);
                return new ResponseEntity<>(createdManager, HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        Optional<ManagerEntity> foundManager = managerService.findManagerById(id);
        String errManagerNotFound = "{\"Error\": \"No Manager found with id " + id + "\"}";

        if (foundManager.isEmpty()) {
            throw new NotFoundException(errManagerNotFound);
        }
        managerService.deleteManager(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<ManagerEntity>> findManagerById(@PathVariable Long id){
        Optional<ManagerEntity> foundManager = managerService.findManagerById(id);
        String errManagerNotFound = "{\"Error\": \"No Managers found with id " + id + "\"}";

        if (foundManager.isEmpty()) {
            throw new NotFoundException(errManagerNotFound);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping()
    public ResponseEntity<Iterable<ManagerEntity>> findAllManagers(){
        Iterable<ManagerEntity> allManagers = managerService.findAllManagers();
        String errManagerNotfound = "{\"Error\": \"No Managers found }";

        if(allManagers == null){
            throw new NotFoundException(errManagerNotfound);
        }
        return new ResponseEntity<>(allManagers,HttpStatus.OK);
    }
    @GetMapping("/findByFullName/{name}")
    public ResponseEntity<List<ManagerEntity>> findManagerByFullName(@PathVariable String name){
        List<ManagerEntity> Manager = managerService.findManagerByFullName(name);
        String errManagerNotfound = "{\"Error\": \"No Manager found }";

        if(Manager == null){
            throw new NotFoundException(errManagerNotfound);
        }
        return new ResponseEntity<>(Manager,HttpStatus.OK);
    }

}



