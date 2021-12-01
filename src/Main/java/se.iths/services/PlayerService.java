package se.iths.services;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.Repository.PlayerRepository;
import se.iths.entitys.PlayerEntity;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerEntity createPlayer(PlayerEntity playerEntity){
        playerEntity.setPassword(passwordEncoder.encode(playerEntity.getPassword()));
        // add role in future
        return playerRepository.save(playerEntity);
    }
    public void deletePlayer(Long id) {
        PlayerEntity foundPlayer = playerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        playerRepository.deleteById(foundPlayer.getId());
    }


    public Optional<PlayerEntity> findPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public Iterable<PlayerEntity> findAllPlayers(){
        return playerRepository.findAll();
    }

    public List<PlayerEntity> findPlayerByFullName(String fullName){
        return playerRepository.findByUserName(fullName);
    }

}
