package se.iths.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.entitys.PlayerEntity;
import se.iths.exceptions.NotFoundException;
import se.iths.services.PlayerService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("")
    public ResponseEntity<PlayerEntity> createPlayer(@RequestBody PlayerEntity player) {
        PlayerEntity createdPlayer = playerService.createPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        Optional<PlayerEntity> foundPlayer = playerService.findPlayerById(id);
        String errPlayerNotFound = "{\"Error\": \"No league found with id " + id + "\"}";

        if (foundPlayer.isEmpty()) {
            throw new NotFoundException(errPlayerNotFound);
        }
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<PlayerEntity>> findPlayerById(@PathVariable Long id) {
        Optional<PlayerEntity> foundPlayer = playerService.findPlayerById(id);
        String errPlayerNotFound = "{\"Error\": \"No league found with id " + id + "\"}";

        if (foundPlayer.isEmpty()) {
            throw new NotFoundException(errPlayerNotFound);
        }
        return new ResponseEntity<>(foundPlayer, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<PlayerEntity>> findAllPlayers() {
        Iterable<PlayerEntity> allPlayers = playerService.findAllPlayers();
        String errPlayersNotFound = "{\"Error\": \"No players found}";

        if(allPlayers == null) {
            throw new NotFoundException(errPlayersNotFound);
        }
        return new ResponseEntity<>(allPlayers, HttpStatus.OK);
    }
    @GetMapping("findByFullName/{name}")
    public ResponseEntity<List<PlayerEntity>> findPlayerByFullName (@PathVariable String name){
        List<PlayerEntity> Player = playerService.findPlayerByFullName(name);
        String errOwnerNotfound = "{\"Error\": \"No Owner found }";

        if(Player == null){
            throw new NotFoundException(errOwnerNotfound);
        }
        return new ResponseEntity<>(Player,HttpStatus.OK);
    }



}
