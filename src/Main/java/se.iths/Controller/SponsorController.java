package se.iths.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.iths.Repository.SponsorRepository;
import se.iths.entitys.SponsorEntity;
import se.iths.entitys.TeamEntity;
import se.iths.exceptions.BeenDeletedException;
import se.iths.exceptions.NotFoundException;
import se.iths.services.SponsorService;
import se.iths.services.TeamService;

@RestController
@RequestMapping("sponsors")
public class SponsorController {

    private final SponsorService sponsorService;
    private final SponsorRepository sponsorRepository;
    private final TeamService teamService;

    public SponsorController(SponsorService sponsorService, SponsorRepository sponsorRepository, TeamService teamService) {
        this.sponsorService = sponsorService;
        this.sponsorRepository = sponsorRepository;
        this.teamService = teamService;
    }

    @PostMapping("")
    public ResponseEntity<SponsorEntity> createSponsor(@RequestBody SponsorEntity sponsor) {
        SponsorEntity createdSponsor = sponsorService.createSponsor(sponsor);
        return new ResponseEntity<>(createdSponsor, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSponsor(@PathVariable Long id) {
        SponsorEntity foundSponsor = sponsorService.findSponsorById(id);
        String errSponsorDeleted = "{\"Error\": \"sponsor deleted with id " + id + "\"}";

        if (foundSponsor == null) {
            throw new BeenDeletedException(errSponsorDeleted);
        }
        sponsorService.deleteSponsor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}")
    public ResponseEntity<SponsorEntity> findSponsorById(@PathVariable Long id) {
        SponsorEntity foundSponsor = sponsorService.findSponsorById(id);
        String errSponsorNotFound = "{\"Error\": \"No sponsor found with id " + id + "\"}";

        if (foundSponsor == null) {
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

    @PutMapping("/{sponsorId}/addSponsorToTeam/{teamId}")
    public SponsorEntity addSponsorToTeam(@PathVariable Long sponsorId, @PathVariable Long teamId) {
        SponsorEntity foundSponsor = sponsorService.findSponsorById(sponsorId);

        TeamEntity foundTeam = teamService.findTeamById(teamId);

        foundTeam.addSponsor(foundSponsor);

        return sponsorRepository.save(foundSponsor);
    }

}
