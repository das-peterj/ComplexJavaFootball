package se.iths.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String teamValue;


    @ManyToOne
    @JoinColumn(name="league_id", referencedColumnName = "id")
    private LeagueEntity leagues;


    @ManyToOne
    @JoinColumn(name="owner_id", referencedColumnName = "id")
    private OwnerEntity owners;


    @OneToMany(mappedBy = "teams")
    private Set<PlayerEntity> players = new HashSet<>();


    @OneToOne(mappedBy = "team")
    private ManagerEntity manager;


    @ManyToMany(mappedBy = "teams")
    private Set<SponsorEntity> sponsors = new HashSet<>();


    public TeamEntity(Long id, String name, String teamValue) {
        this.id = id;
        this.name = name;
        this.teamValue = teamValue;
    }

    public TeamEntity (){}

    public Set<SponsorEntity> getSponsors() {
        return sponsors;
    }

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

//    public void addManager(ManagerEntity managerEntity) {
//        this.managerEntity = managerEntity;
//        managerEntity.setTeam(this);
//    }

    public void addSponsor(SponsorEntity sponsor) {
        sponsors.add(sponsor);
    }
    //behövs nog ändras lite om en sponsor ska kunna vara sponsor på flera teams
    // då detta antagligen skriver över den nuvarande sponsoren

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

//    public ManagerEntity getManagerEntity() {
//        return managerEntity;
//    }
//
//    public void setManagerEntity(ManagerEntity managerEntity) {
//        this.managerEntity = managerEntity;
//    }


}
