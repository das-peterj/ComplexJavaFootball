package se.iths.services;


import org.springframework.stereotype.Service;
import se.iths.Repository.SponsorRepository;
import se.iths.entitys.SponsorEntity;
import se.iths.exceptions.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class SponsorService {

    private final SponsorRepository sponsorRepository;

    public SponsorService(SponsorRepository sponsorRepository){
        this.sponsorRepository = sponsorRepository;
    }

    public SponsorEntity createSponsor(SponsorEntity sponsorEntity){
        return sponsorRepository.save(sponsorEntity);
    }
    public void deleteSponsor(Long id) {
        SponsorEntity foundSponsor = sponsorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        sponsorRepository.deleteById(foundSponsor.getId());
    }


    public SponsorEntity findSponsorById(Long id) {
        return sponsorRepository.findById(id).orElseThrow(()-> new NotFoundException("Could not find this sponsor with id " + id));
    }

    public Iterable<SponsorEntity> findAllSponsors() {
        return sponsorRepository.findAll();
    }

    public SponsorEntity findSponsorByName(String name) {
        return sponsorRepository.findByName(name);
    }
}
