package se.iths.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.entitys.TeamEntity;
import se.iths.exceptions.NotFoundException;
import se.iths.services.TeamService;
import java.util.Optional;

@RestController
@RequestMapping("teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("")
    public ResponseEntity<TeamEntity> createTeam(@RequestBody TeamEntity team) {
        TeamEntity createdTeam = teamService.createTeam(team);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        Optional<TeamEntity> foundTeam = teamService.findTeamById(id);
        String errTeamNotFound = "{\"Error\": \"No team found with id " + id + "\"}";

        if (foundTeam.isEmpty()) {
            throw new NotFoundException(errTeamNotFound);
        }
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<TeamEntity>> findTeamById(@PathVariable Long id) {
        Optional<TeamEntity> foundTeam = teamService.findTeamById(id);
        String errTeamNotFound = "{\"Error\": \"No team found with id " + id + "\"}";

        if (foundTeam.isEmpty()) {
            throw new NotFoundException(errTeamNotFound);
        }
        return new ResponseEntity<>(foundTeam, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<TeamEntity>> findAllTeams() {
        Iterable<TeamEntity> allTeams = teamService.findAllTeams();
        String errTeamsNotFound = "{\"Error\": \"No players found}";

        if(allTeams == null) {
            throw new NotFoundException(errTeamsNotFound);
        }
        return new ResponseEntity<>(allTeams, HttpStatus.OK);
    }

    @PostMapping("{teamId}/addPlayer/{playerId}")
    public TeamEntity addPlayerToTeam(@PathVariable Long teamId, @PathVariable Long playerId) {
        return teamService.addPlayerToTeam(teamId, playerId);
    }
}
