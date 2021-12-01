package se.iths.services;
import org.springframework.stereotype.Service;
import se.iths.Repository.LeagueRepository;
import se.iths.entitys.LeagueEntity;

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
        LeagueEntity foundLeague = leagueRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        leagueRepository.deleteById(foundLeague.getId());
    }

    public Optional<LeagueEntity> findLeagueById(Long id) {
        return leagueRepository.findById(id);
    }

    public Iterable<LeagueEntity> findAllLeagues(){
        return leagueRepository.findAll();
    }

    public List<LeagueEntity> findLeagueByName(String name){
        return leagueRepository.findByLeagueName(name);
    }
}
