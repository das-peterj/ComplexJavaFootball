package se.iths.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.entitys.SponsorEntity;
import se.iths.exceptions.NotFoundException;
import se.iths.services.SponsorService;

import java.util.Optional;

@RestController
@RequestMapping("sponsors")
public class SponsorController {

    private final SponsorService sponsorService;

    public SponsorController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    @PostMapping("")
    public ResponseEntity<SponsorEntity> createSponsor(@RequestBody SponsorEntity sponsor) {
        SponsorEntity createdSponsor = sponsorService.createSponsor(sponsor);
        return new ResponseEntity<>(createdSponsor, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSponsor(@PathVariable Long id) {
        Optional<SponsorEntity> foundSponsor = sponsorService.findSponsorById(id);
        String errSponsorNotFound = "{\"Error\": \"No sponsor found with id " + id + "\"}";

        if (foundSponsor.isEmpty()) {
            throw new NotFoundException(errSponsorNotFound);
        }
        sponsorService.deleteSponsor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<SponsorEntity>> findSponsorById(@PathVariable Long id) {
        Optional<SponsorEntity> foundSponsor = sponsorService.findSponsorById(id);
        String errSponsorNotFound = "{\"Error\": \"No sponsor found with id " + id + "\"}";

        if (foundSponsor.isEmpty()) {
            throw new NotFoundException(errSponsorNotFound);
        }
        return new ResponseEntity<>(foundSponsor, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<SponsorEntity>> findAllPlayers() {
        Iterable<SponsorEntity> allSponsors = sponsorService.findAllSponsors();
        String errSponsorsNotFound = "{\"Error\": \"No sponsors found}";

        if(allSponsors == null) {
            throw new NotFoundException(errSponsorsNotFound);
        }
        return new ResponseEntity<>(allSponsors, HttpStatus.OK);
    }
}
