package se.iths.entitys;

import javax.persistence.*;
import java.util.*;

@Entity
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String teamValue;

    @ManyToOne
    private LeagueEntity leagues;

    @ManyToOne
    private OwnerEntity owners;

    @OneToMany(mappedBy = "teams", cascade = CascadeType.PERSIST)
    private Set<PlayerEntity> players = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private ManagerEntity managerEntity;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SponsorEntity> sponsors = new HashSet<>();

    public void addOwner(OwnerEntity ownerEntity) {
        this.owners = ownerEntity;
        ownerEntity.getTeams().add(this);
    }

    public void addLeague(LeagueEntity leagueEntity) {
        this.leagues = leagueEntity;
        leagueEntity.getTeams().add(this);
    }

    public void addPlayer(PlayerEntity playerEntity) {
        this.players.add(playerEntity);
        playerEntity.setTeamEntity(this);
    }

    public void addManager(ManagerEntity managerEntity) {
        this.managerEntity = managerEntity;
        managerEntity.setTeamEntity(this);
    }

    //behövs nog ändras lite om en sponsor ska kunna vara sponsor på flera teams
    // då detta antagligen skriver över den nuvarande sponsoren
    public void addSponsor(SponsorEntity sponsorEntity) {
        this.sponsors.add(sponsorEntity);
        sponsorEntity.setTeamEntities(this);
    }

    public void setManager(ManagerEntity manager) {
        this.managerEntity = manager;
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

    public LeagueEntity getLeagueEntity() {
        return leagues;
    }

    public void setLeagueEntity(LeagueEntity leagueEntity) {
        this.leagues = leagueEntity;
    }

    public OwnerEntity getOwnerEntity() {
        return owners;
    }

    public void setOwnerEntity(OwnerEntity ownerEntity) {
        this.owners = ownerEntity;
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
