package se.iths.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.Repository.ManagerRepository;
import se.iths.entitys.ManagerEntity;
import se.iths.entitys.TeamEntity;
import se.iths.exceptions.BeenDeletedException;
import se.iths.exceptions.NotFoundException;
import se.iths.services.ManagerService;
import se.iths.services.TeamService;

@RestController
@RequestMapping("managers")
public class ManagerController {

    private final ManagerRepository managerRepository;
    private final ManagerService managerService;
    private final TeamService teamService;

    public ManagerController(ManagerRepository managerRepository, ManagerService managerService, TeamService teamService){
        this.managerRepository = managerRepository;
        this.managerService = managerService;
        this.teamService = teamService;
    }

    @PostMapping("")
    public ResponseEntity<ManagerEntity> createManager(@RequestBody ManagerEntity manager){
        ManagerEntity createdManager = managerService.createManager(manager);
                return new ResponseEntity<>(createdManager, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        ManagerEntity foundManager = managerService.findManagerById(id);
        String errManagerDeleted = "{\"Error\": \" Manager deleted with id " + id + "\"}";

        if (foundManager == null) {
            throw new BeenDeletedException(errManagerDeleted);
        }
        managerService.deleteManager(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity <ManagerEntity> findManagerById(@PathVariable Long id){
        ManagerEntity foundManager = managerService.findManagerById(id);
        String errManagerNotFound = "{\"Error\": \"No Managers found with id " + id + "\"}";

        if (foundManager == null) {
            throw new NotFoundException(errManagerNotFound);
        }
        return new ResponseEntity<>(foundManager, HttpStatus.OK);
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

    @PutMapping("/{managerId}/addManagerToTeam/{teamId}")
    public ManagerEntity addManagerToTeam(@PathVariable Long managerId, @PathVariable Long teamId) {
        ManagerEntity foundManager = managerService.findManagerById(managerId);
        TeamEntity foundTeam = teamService.findTeamById(teamId);

        foundManager.addTeam(foundTeam);
        return managerRepository.save(foundManager);
    }
}



