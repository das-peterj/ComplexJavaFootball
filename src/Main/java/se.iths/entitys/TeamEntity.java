package se.iths.entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String teamValue;

    @ManyToOne
    private LeagueEntity leagueEntity;

    @ManyToOne
    private OwnerEntity ownerEntity;

    @OneToMany(mappedBy = "teams", cascade = CascadeType.ALL)
    private List<PlayerEntity> players = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private ManagerEntity managerEntity;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<SponsorEntity> sponsors = new HashSet<>();


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
        return leagueEntity;
    }

    public void setLeagueEntity(LeagueEntity leagueEntity) {
        this.leagueEntity = leagueEntity;
    }

    public OwnerEntity getOwnerEntity() {
        return ownerEntity;
    }

    public void setOwnerEntity(OwnerEntity ownerEntity) {
        this.ownerEntity = ownerEntity;
    }

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerEntity> players) {
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
