package se.iths.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String teamValue;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="league_id", referencedColumnName = "id")
    private LeagueEntity leagues;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="owner_id", referencedColumnName = "id")
    private OwnerEntity owners;


    @OneToMany(mappedBy = "teams")
    private Set<PlayerEntity> players = new HashSet<>();

    @OneToOne(mappedBy = "team")
    private ManagerEntity managerEntity;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SponsorEntity> sponsors = new HashSet<>();



    public OwnerEntity getOwners() {
        return owners;
    }

    public void setOwners(OwnerEntity owners) {
        this.owners = owners;
    }

    public void addOwner(OwnerEntity ownerEntity) {
        this.owners = ownerEntity;
    }

    public void addLeague(LeagueEntity league) {
        this.leagues = league;
    }

    public void addPlayer(PlayerEntity playerEntity) {
        this.players.add(playerEntity);
        playerEntity.setTeams(this);
    }

    public void addManager(ManagerEntity managerEntity) {
        this.managerEntity = managerEntity;
        managerEntity.setTeam(this);
    }

    //behövs nog ändras lite om en sponsor ska kunna vara sponsor på flera teams
    // då detta antagligen skriver över den nuvarande sponsoren
    public void addSponsor(SponsorEntity sponsorEntity) {
        this.sponsors.add(sponsorEntity);
        sponsorEntity.setTeamEntities(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamValue() {
        return teamValue;
    }

    public void setTeamValue(String teamValue) {
        this.teamValue = teamValue;
    }

    public LeagueEntity getLeagues() {
        return leagues;
    }

    public void setLeagues(LeagueEntity leagues) {
        this.leagues = leagues;
    }

    public Set<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(Set<PlayerEntity> players) {
        this.players = players;
    }

    public ManagerEntity getManagerEntity() {
        return managerEntity;
    }

    public void setManagerEntity(ManagerEntity managerEntity) {
        this.managerEntity = managerEntity;
    }

    public Set<SponsorEntity> getSponsors() {
        return sponsors;
    }

    public void setSponsors(Set<SponsorEntity> sponsors) {
        this.sponsors = sponsors;
    }
}
