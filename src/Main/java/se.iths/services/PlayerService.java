package se.iths.services;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.Repository.PlayerRepository;
import se.iths.Repository.RoleRepository;
import se.iths.entitys.PlayerEntity;
import se.iths.entitys.RoleEntity;
import se.iths.exceptions.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final RoleRepository roleRepository;

     private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public PlayerService(PlayerRepository playerRepository, RoleRepository roleRepository) {
        this.playerRepository = playerRepository;
        this.roleRepository = roleRepository;
    }


    public PlayerEntity createPlayer(PlayerEntity playerEntity){
//        playerEntity.setPassword(passwordEncoder.encode(playerEntity.getPassword()));
        // add role in future
        playerEntity.setPassword(passwordEncoder.encode(playerEntity.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_PLAYER");
        playerEntity.addRole(roleToAdd);
        return playerRepository.save(playerEntity);
    }
    public void deletePlayer(Long id) {
        PlayerEntity foundPlayer = playerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        playerRepository.deleteById(foundPlayer.getId());
    }


    public PlayerEntity findPlayerById(Long id) {
        return playerRepository.findById(id).orElseThrow(()-> new NotFoundException("Could not find this player with id " + id));
    }

    public Iterable<PlayerEntity> findAllPlayers(){
        return playerRepository.findAll();
    }

    public List<PlayerEntity> findPlayerByFullName(String fullName){
        return playerRepository.findByUserName(fullName);
    }

}
