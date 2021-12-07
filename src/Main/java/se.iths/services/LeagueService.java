package se.iths.services;
import org.springframework.stereotype.Service;
import se.iths.Repository.LeagueRepository;
import se.iths.entitys.LeagueEntity;
import se.iths.exceptions.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;


    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public LeagueEntity createLeague(LeagueEntity leagueEntity){
        // add role in future
        return leagueRepository.save(leagueEntity);
    }
    public void deleteLeague(Long id) {
        LeagueEntity foundLeague = leagueRepository.findById(id).orElseThrow(() -> new NotFoundException(""));
    }

    public LeagueEntity findLeagueById(Long leagueId) {
        return leagueRepository.findById(leagueId).orElseThrow(()-> new NotFoundException("Could not find this league with id " + leagueId));
    }


    public Iterable<LeagueEntity> findAllLeagues(){
        return leagueRepository.findAll();
    }

    public List<LeagueEntity> findLeagueByName(String name){
        return leagueRepository.findByLeagueName(name);
    }
}
