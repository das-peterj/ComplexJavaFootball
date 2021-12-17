package se.iths.services;


import org.springframework.stereotype.Service;
import se.iths.Repository.UserRepository;
import se.iths.entitys.PlayerEntity;
import se.iths.entitys.UserEntity;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public Iterable<UserEntity> findAllUsers(){
        return userRepository.findAll();
    }
}

