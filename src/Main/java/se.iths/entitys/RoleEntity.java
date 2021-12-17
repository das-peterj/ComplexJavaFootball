package se.iths.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RoleEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;


    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users = new HashSet<>();

    @ManyToMany(mappedBy = "roles")
    private Set<OwnerEntity> owners = new HashSet<>();

    @ManyToMany(mappedBy = "roles")
    private Set<ManagerEntity> managers = new HashSet<>();

    @ManyToMany(mappedBy = "roles")
    private Set<PlayerEntity> players = new HashSet<>();

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public RoleEntity(String role) {
        this.role = role;
    }

    public RoleEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonIgnore
    public Set<OwnerEntity> getOwners() {
        return owners;
    }

    public void setOwners(Set<OwnerEntity> owners) {
        this.owners = owners;
    }

    @JsonIgnore
    public Set<ManagerEntity> getManagers() {
        return managers;
    }

    public void setManagers(Set<ManagerEntity> managers) {
        this.managers = managers;
    }

    @JsonIgnore
    public Set<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(Set<PlayerEntity> players) {
        this.players = players;
    }


}
