package se.iths.services;

import org.springframework.stereotype.Service;
import se.iths.Repository.PlayerRepository;
import se.iths.Repository.TeamRepository;
import se.iths.entitys.PlayerEntity;
import se.iths.entitys.TeamEntity;
import se.iths.exceptions.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;




    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamEntity createTeam(TeamEntity teamEntity){

        return teamRepository.save(teamEntity);
    }
    public void deleteTeam(Long id) {
        TeamEntity foundTeam = teamRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        teamRepository.deleteById(foundTeam.getId());
    }

    public TeamEntity findTeamById(Long id) {
        return teamRepository.findById(id).orElseThrow(()-> new NotFoundException("Could not find this team with id " + id));
    }

    public Iterable<TeamEntity> findAllTeams(){
        return teamRepository.findAll();
    }

    public TeamEntity findTeamByName(String teamName){
        return teamRepository.findByName(teamName);
    }


}
