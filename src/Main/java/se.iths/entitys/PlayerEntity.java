package se.iths.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.tomcat.jni.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class PlayerEntity extends UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String position;
    private String marketValue;


    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="team_id", referencedColumnName = "id")
    private TeamEntity teams;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RoleEntity> roles = new HashSet<>();



    public void addRole(RoleEntity role) {
        this.roles.add(role);
//        role.getPlayers().add(this);
    }

    public void removeRole(RoleEntity role) {
        roles.remove(role);
        role.getPlayers().remove(this);
    }

    public PlayerEntity(Long id, String fullName, String position, String marketValue) {
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.marketValue = marketValue;

    }

    public PlayerEntity() {
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
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
