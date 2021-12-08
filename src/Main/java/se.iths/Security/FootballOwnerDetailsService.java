package se.iths.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.Repository.OwnerRepository;
import se.iths.entitys.OwnerEntity;

@Service
public class FootballOwnerDetailsService implements UserDetailsService {

    private final OwnerRepository ownerRepository;

    public FootballOwnerDetailsService(OwnerRepository ownerRepository){
        super();
        this.ownerRepository = ownerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OwnerEntity ownerEntity = (OwnerEntity) ownerRepository.findByUserName(username);
        if (ownerEntity == null) {
            throw new UsernameNotFoundException("Can't find owner with username: " + "username");
        }
        return new FootballOwnerPrincipal(ownerEntity);

    }
}
