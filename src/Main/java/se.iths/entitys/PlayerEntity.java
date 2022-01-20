package se.iths.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.tomcat.jni.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String position;
    private String marketValue;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="team_id")
    private TeamEntity teams;


    public PlayerEntity(Long id, String fullName, String position, String marketValue) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.marketValue = marketValue;

    }

    public PlayerEntity() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public TeamEntity getTeams() {
        return teams;
    }

    public void setTeams(TeamEntity teams) {
        this.teams = teams;
    }

    public void addTeam(TeamEntity foundTeam) {
        this.teams = foundTeam;
    }
}
