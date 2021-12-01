package se.iths.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.entitys.OwnerEntity;
import se.iths.exceptions.NotFoundException;
import se.iths.services.OwnerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService){
        this.ownerService= ownerService;
    }

    @PostMapping("")
    public ResponseEntity<OwnerEntity> createOwner(@RequestBody OwnerEntity owner){
        OwnerEntity createdOwner = ownerService.createOwner(owner);
        return new ResponseEntity<>(createdOwner, HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        Optional<OwnerEntity> foundOwner = ownerService.findOwnerById(id);
        String errOwnerNotFound = "{\"Error\": \"No Owner found with id " + id + "\"}";

        if (foundOwner.isEmpty()) {
            throw new NotFoundException(errOwnerNotFound);
        }
        ownerService.deleteOwner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("{id}")
    public ResponseEntity<Optional<OwnerEntity>> findOwnerById(@PathVariable Long id){
        Optional<OwnerEntity> foundOwner = ownerService.findOwnerById(id);
        String errOwnerNotFound = "{\"Error\": \"No Owners found with id " + id + "\"}";

        if (foundOwner.isEmpty()) {
            throw new NotFoundException(errOwnerNotFound);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
    @GetMapping("findByFullName/{name}")
    public ResponseEntity<List<OwnerEntity>> findOwnerByFullName (@PathVariable String name){
        List<OwnerEntity> Owner = ownerService.findOwnerByFullName(name);
        String errOwnerNotfound = "{\"Error\": \"No Owner found }";

        if(Owner == null){
            throw new NotFoundException(errOwnerNotfound);
        }
        return new ResponseEntity<>(Owner,HttpStatus.OK);
    }

}
