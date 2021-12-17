package se.iths.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.Repository.OwnerRepository;
import se.iths.Repository.TeamRepository;
import se.iths.entitys.OwnerEntity;
import se.iths.entitys.TeamEntity;
import se.iths.exceptions.BeenDeletedException;
import se.iths.exceptions.NotFoundException;
import se.iths.services.OwnerService;
import se.iths.services.TeamService;

@RestController
@RequestMapping("owners")
public class OwnerController {

    private final OwnerService ownerService;
    private final TeamService teamService;
    private final TeamRepository teamRepository;
    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerService ownerService, TeamService teamService, TeamRepository teamRepository, OwnerRepository ownerRepository){
        this.ownerService= ownerService;
        this.teamService = teamService;
        this.teamRepository = teamRepository;
        this.ownerRepository = ownerRepository;
    }

//    @PostMapping("")
//    public ResponseEntity<OwnerEntity> createOwner(@RequestBody OwnerEntity owner){
//        OwnerEntity createdOwner = ownerService.createOwner(owner);
//        return new ResponseEntity<>(createdOwner, HttpStatus.CREATED);
//    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        OwnerEntity foundOwner = ownerService.findOwnerById(id);
        String errOwnerDeleted = "{\"Error\": \"Owner deleted  with id " + id + "\"}";

        if (foundOwner == null) {
            throw new BeenDeletedException(errOwnerDeleted);
        }
        ownerService.deleteOwner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("{id}")
    public ResponseEntity<OwnerEntity> findOwnerById(@PathVariable Long id){
        OwnerEntity foundOwner = ownerService.findOwnerById(id);
        String errOwnerNotFound = "{\"Error\": \"No Owners found with id " + id + "\"}";

        if (foundOwner == null) {
            throw new NotFoundException(errOwnerNotFound);
        }
        return new ResponseEntity<>(foundOwner, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<OwnerEntity>> findAllOwners(){
        Iterable<OwnerEntity> allOwners = ownerService.findAllOwners();
        String errOwnerNotfound = "{\"Error\": \"No Owners found }";

        if(allOwners == null){
            throw new NotFoundException(errOwnerNotfound);
        }
        return new ResponseEntity<>(allOwners,HttpStatus.OK);
    }

    @PutMapping("/{ownerId}/addOwnerToTeam/{teamId}")
    public OwnerEntity addOwnerToTeam(@PathVariable Long ownerId, @PathVariable Long teamId) {
        TeamEntity foundTeam = teamService.findTeamById(teamId);
        OwnerEntity foundOwner = ownerService.findOwnerById(ownerId);

        foundTeam.addOwner(foundOwner);
        return ownerRepository.save(foundOwner);
    }

    /*
    @GetMapping("findByFullName/{name}")
    public ResponseEntity<List<OwnerEntity>> findOwnerByFullName (@PathVariable String name){
        List<OwnerEntity> Owner = ownerService.findOwnerByFullName(name);
        String errOwnerNotfound = "{\"Error\": \"No Owner found }";

        if(Owner == null){
            throw new NotFoundException(errOwnerNotfound);
        }
        return new ResponseEntity<>(Owner,HttpStatus.OK);
    }*/

}
