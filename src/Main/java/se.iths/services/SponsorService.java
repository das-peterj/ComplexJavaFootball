package se.iths.services;


import org.springframework.stereotype.Service;
import se.iths.Repository.SponsorRepository;
import se.iths.entitys.SponsorEntity;

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


    public Optional<SponsorEntity> findSponsorById(Long id) {
        return sponsorRepository.findById(id);
    }

    public Iterable<SponsorEntity> findAllSponsors() {
        return sponsorRepository.findAll();
    }

    public List<SponsorEntity> findSponsorByName(String name) {
        return sponsorRepository.findByName(name);
    }
}
