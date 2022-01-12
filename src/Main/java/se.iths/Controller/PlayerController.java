package se.iths.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.Repository.PlayerRepository;
import se.iths.entitys.PlayerEntity;
import se.iths.entitys.TeamEntity;
import se.iths.exceptions.BeenDeletedException;
import se.iths.exceptions.NotFoundException;
import se.iths.services.PlayerService;
import se.iths.services.TeamService;

import java.util.Optional;

@RestController
@RequestMapping("players")
public class PlayerController {

    private final PlayerRepository playerRepository;
    private final PlayerService playerService;
    private final TeamService teamService;

    public PlayerController(PlayerRepository playerRepository, PlayerService playerService, TeamService teamService) {
        this.playerRepository = playerRepository;
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @PostMapping("")
    public ResponseEntity<PlayerEntity> createPlayer(@RequestBody PlayerEntity player) {
        PlayerEntity createdPlayer = playerService.createPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        PlayerEntity foundPlayer = playerService.findPlayerById(id);
        String errPlayerNotFound = "{\"Error\": \"League with id " + id + " has been deleted\"}";

        if (foundPlayer == null) {
            throw new BeenDeletedException(errPlayerNotFound);
        }
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<PlayerEntity>> findPlayerById(@PathVariable Long id) {
        Optional<PlayerEntity> foundPlayer = Optional.ofNullable(playerService.findPlayerById(id));
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

    @PutMapping("/{playerId}/addPlayerToTeam/{teamId}")
    public PlayerEntity addPlayerToTeam(@PathVariable Long playerId, @PathVariable Long teamId) {
        PlayerEntity foundPlayer = playerService.findPlayerById(playerId);
        TeamEntity foundTeam = teamService.findTeamById(teamId);

        foundPlayer.addTeam(foundTeam);
        return playerRepository.save(foundPlayer);
    }

}
