package se.iths.services;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.iths.Repository.OwnerRepository;
import se.iths.entitys.OwnerEntity;
import se.iths.exceptions.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public OwnerEntity createOwner (OwnerEntity ownerEntity){
//        ownerEntity.setPassword(passwordEncoder.encode(ownerEntity.getPassword()));
        // add role in future
        return ownerRepository.save(ownerEntity);
    }
    public void deleteOwner(Long id) {
        OwnerEntity foundOwner = ownerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        ownerRepository.deleteById(foundOwner.getId());
    }


    public OwnerEntity findOwnerById(Long id) {
        return ownerRepository.findById(id).orElseThrow(()-> new NotFoundException("Could not find this owner with id " + id));
    }

    public Iterable<OwnerEntity> findAllOwners(){
        return ownerRepository.findAll();
    }

    public List<OwnerEntity> findOwnerByFullName(String fullName){
        return ownerRepository.findByFullName(fullName);
    }

}