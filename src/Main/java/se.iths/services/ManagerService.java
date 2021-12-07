package se.iths.services;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.Repository.ManagerRepository;
import se.iths.entitys.ManagerEntity;
import se.iths.exceptions.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {


    private final ManagerRepository managerRepository;

//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public ManagerEntity createManager(ManagerEntity managerEntity){
//        managerEntity.setPassword(passwordEncoder.encode(managerEntity.getPassword()));
        // add role in future
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

    public List<ManagerEntity> findManagerByFullName(String fullName){
        return managerRepository.findByFullName(fullName);
    }


}
