package se.iths.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ManagerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String age;
    private String email;
    private String userName;
    private String password;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teamId", referencedColumnName = "id")
    private TeamEntity team;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RoleEntity> roles = new HashSet<>();

    public ManagerEntity(Long id, String fullName, String phoneNumber, String age, String email, String userName, String password) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public ManagerEntity() {
    }

    public void addRole(RoleEntity role){
        this.roles.add(role);
        //role.getManagers().add(this);
    }
    public void removeRole(RoleEntity role){
        roles.remove(role);
        role.getManagers().remove(this);
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addTeam(TeamEntity foundTeam) {
        this.team = foundTeam;
    }
}
