package se.iths.services;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.Repository.RoleRepository;
import se.iths.Repository.UserRepository;
import se.iths.entitys.RoleEntity;
import se.iths.entitys.UserEntity;

import javax.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UserEntity findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public Iterable<UserEntity> findAllUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public UserEntity createUser (UserEntity userEntity){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByRole("USER");
        userEntity.addRole(roleToAdd);
        userRepository.save(userEntity);
        return userEntity;
    }

    public void addRoleToUser(String username, String roleName) {
        UserEntity user = userRepository.findByUserName(username);
        RoleEntity role = roleRepository.findByRole(roleName);
        user.addRole(role);
    }

}

