package se.iths.entitys;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class LeagueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String leagueName;
    private String country;


    @OneToMany(mappedBy = "leagues")
    private Set<TeamEntity> teams = new HashSet<>();

    public LeagueEntity(Long id, String leagueName, String country) {
        this.id = id;
        this.leagueName = leagueName;
        this.country = country;
    }

    public LeagueEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<TeamEntity> getTeams() {
        return teams;
    }

    public void setTeams(Set<TeamEntity> teams) {
        this.teams = teams;
    }

}