package se.iths.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.Repository.ManagerRepository;
import se.iths.entitys.ManagerEntity;

@Service
public class FootballManagerDetailsService implements UserDetailsService {

    private final ManagerRepository managerRepository;

    public FootballManagerDetailsService(ManagerRepository managerRepository){
        super();
        this.managerRepository = managerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ManagerEntity managerEntity = (ManagerEntity) managerRepository.findByUserName(username);
        if (managerEntity == null){
            throw new UsernameNotFoundException("Can't find manager with username: \" + \"username");
        }
        return new FootballManagerPrincipal(managerEntity);
    }
}
