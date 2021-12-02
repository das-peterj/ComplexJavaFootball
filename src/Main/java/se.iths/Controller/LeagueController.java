package se.iths.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.entitys.LeagueEntity;
import se.iths.exceptions.NotFoundException;
import se.iths.services.LeagueService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("leagues")
public class LeagueController {

    private final LeagueService leagueService;

    public LeagueController(LeagueService leagueService) {
        this.leagueService = leagueService;
    }

    @PostMapping("")
    public ResponseEntity<LeagueEntity> createLeague(@RequestBody LeagueEntity league) {
        LeagueEntity createdLeague = leagueService.createLeague(league);
        return new ResponseEntity<>(createdLeague, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLeague(@PathVariable Long id) {
        Optional<LeagueEntity> foundLeague = leagueService.findLeagueById(id);
        String errLeagueNotFound = "{\"Error\": \"No league found with id " + id + "\"}";

        if (foundLeague.isEmpty()) {
            throw new NotFoundException(errLeagueNotFound);
        }
        leagueService.deleteLeague(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<LeagueEntity>> findLeagueById(@PathVariable Long id) {
        Optional<LeagueEntity> foundLeague = leagueService.findLeagueById(id);
        String errLeagueNotFound = "{\"Error\": \"No league found with id " + id + "\"}";

        if (foundLeague.isEmpty()) {
            throw new NotFoundException(errLeagueNotFound);
        }
        return new ResponseEntity<>(foundLeague, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<LeagueEntity>> findAllLeagues() {
        Iterable<LeagueEntity> allLeagues = leagueService.findAllLeagues();
        String errLeagueNotFound = "{\"Error\": \"No leagues found}";

        if(allLeagues == null) {
            throw new NotFoundException(errLeagueNotFound);
        }
        return new ResponseEntity<>(allLeagues, HttpStatus.OK);
    }
    
    
    //Behövs att fixas.
    @GetMapping("findByName/{name}")
    public ResponseEntity<List<LeagueEntity>> findLeagueByFullName (@PathVariable String name){
        List<LeagueEntity> league = leagueService.findLeagueByName(name);
        String errLeagueNotfound = "{\"Error\": \"No League found }";

        if(league == null){
            throw new NotFoundException(errLeagueNotfound);
        }
        return new ResponseEntity<>(league,HttpStatus.OK);
    }





}
