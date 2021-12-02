package se.iths.services;

import org.springframework.stereotype.Service;
import se.iths.Repository.TeamRepository;
import se.iths.entitys.PlayerEntity;
import se.iths.entitys.TeamEntity;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    PlayerService playerService;


    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamEntity createTeam(TeamEntity teamEntity){
        // add role in future
        return teamRepository.save(teamEntity);
    }
    public void deleteTeam(Long id) {
        TeamEntity foundTeam = teamRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        teamRepository.deleteById(foundTeam.getId());
    }


    public Optional<TeamEntity> findTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Iterable<TeamEntity> findAllTeams(){
        return teamRepository.findAll();
    }

    public List<TeamEntity> findTeamByName(String teamName){
        return teamRepository.findByName(teamName);
    }

    public TeamEntity addPlayerToTeam(Long teamId, Long playerId) {
        TeamEntity foundTeam = findTeamById(teamId).get();
        PlayerEntity foundPlayer = playerService.findPlayerById(playerId);

        foundTeam.addPlayer(foundPlayer);
        teamRepository.save(foundTeam);

        return foundTeam;
    }

}
