package se.iths.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import se.iths.Repository.LeagueRepository;
import se.iths.Repository.TeamRepository;
import se.iths.entitys.LeagueEntity;
import se.iths.entitys.OwnerEntity;
import se.iths.entitys.TeamEntity;
import se.iths.exceptions.NotFoundException;
import se.iths.services.LeagueService;
import se.iths.services.OwnerService;
import se.iths.services.TeamService;

@RestController
@RequestMapping("teams")
public class TeamController {

    private final OwnerService ownerService;
    private final TeamRepository teamRepository;
    private final TeamService teamService;
    private final LeagueService leagueService;

    public TeamController(OwnerService ownerService, TeamRepository teamRepository, TeamService teamService, LeagueService leagueService) {
        this.ownerService = ownerService;
        this.teamRepository = teamRepository;
        this.teamService = teamService;
        this.leagueService = leagueService;
    }

    @PostMapping("")
    public ResponseEntity<TeamEntity> createTeam(@RequestBody TeamEntity team) {
        TeamEntity createdTeam = teamService.createTeam(team);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        TeamEntity foundTeam = teamService.findTeamById(id);
        String errTeamNotFound = "{\"Error\": \"No team found with id " + id + "\"}";

        if (foundTeam == null) {
            throw new NotFoundException(errTeamNotFound);
        }
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<TeamEntity> findTeamById(@PathVariable Long id) {
        TeamEntity foundTeam = teamService.findTeamById(id);
        String errTeamNotFound = "{\"Error\": \"No team found with id " + id + "\"}";

        if (foundTeam == null) {
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

    @PutMapping("/{teamId}/addTeamToLeague/{leagueId}")
    public TeamEntity addTeamToLeague(@PathVariable Long teamId, @PathVariable Long leagueId) {
        TeamEntity foundTeam = teamService.findTeamById(teamId);

        LeagueEntity foundLeague = leagueService.findLeagueById(leagueId);

        foundTeam.addLeague(foundLeague);

        return teamRepository.save(foundTeam);
    }


}
