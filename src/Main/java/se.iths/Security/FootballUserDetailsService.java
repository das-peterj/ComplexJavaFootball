package se.iths.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.iths.Repository.UserRepository;
import se.iths.entitys.UserEntity;

@Service
public class FootballUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;


    public FootballUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Can't find user with username: " + userName);
        }
        return new FootballUserPrincipal(userEntity);
    }
}
