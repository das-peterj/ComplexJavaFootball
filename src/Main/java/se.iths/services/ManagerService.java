package se.iths.services;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.Repository.ManagerRepository;
import se.iths.Repository.RoleRepository;
import se.iths.entitys.ManagerEntity;
import se.iths.entitys.RoleEntity;
import se.iths.exceptions.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {


    private final ManagerRepository managerRepository;
    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ManagerService(ManagerRepository managerRepository, RoleRepository roleRepository) {
        this.managerRepository = managerRepository;
        this.roleRepository = roleRepository;
    }

    public ManagerEntity createManager(ManagerEntity managerEntity){
        managerEntity.setPassword(passwordEncoder.encode(managerEntity.getPassword()));
        RoleEntity roleToAdd = roleRepository.findByRole("ROLE_MANAGER");
        managerEntity.addRole(roleToAdd);
        return managerRepository.save(managerEntity);
    }
    public void deleteManager(Long id) {
        ManagerEntity foundManager = managerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        managerRepository.deleteById(foundManager.getId());
    }


    public ManagerEntity findManagerById(Long id) {
        return managerRepository.findById(id).orElseThrow(()-> new NotFoundException("Could not find this manager with id " + id));
    }

    public Iterable<ManagerEntity> findAllManagers(){
        return managerRepository.findAll();
    }

//    public List<ManagerEntity> findManagerByFullName(String fullName){
//        return managerRepository.findByFullName(fullName);
//    }


}
