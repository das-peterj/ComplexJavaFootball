package se.iths.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.Repository.PlayerRepository;
import se.iths.entitys.PlayerEntity;

@Service
public class FootballUserDetailsService implements UserDetailsService {


    private final PlayerRepository playerRepository;

    public FootballUserDetailsService(PlayerRepository playerRepository) {
        super();
        this.playerRepository = playerRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PlayerEntity playerEntity = (PlayerEntity) playerRepository.findByUserName(username);
        if (playerEntity == null) {
            throw new UsernameNotFoundException("Can't find user with username: " + "username");
        }
        return new FootballUserPrincipal(playerEntity);
    }
}
