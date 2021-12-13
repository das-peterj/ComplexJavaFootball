package se.iths.entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class OwnerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String netWorth;
    private String phoneNumber;
    private String age;
    private String userName;
    private String password;


    @OneToMany(mappedBy = "owners")
    private Set<TeamEntity> teams = new HashSet<>();

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<RoleEntity> roles = new HashSet<>();

    public void addRole(RoleEntity role){
        this.roles.add(role);
        // role.getOwners().add(this);
    }
    public void removeRole(RoleEntity role){
        roles.remove(role);
        role.getOwners().remove(this);
    }

    public OwnerEntity(Long id, String fullName, String netWorth, String phoneNumber, String age, String userName, String password) {
        this.id = id;
        this.fullName = fullName;
        this.netWorth = netWorth;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.userName = userName;
        this.password = password;
    }

    public OwnerEntity() {
    }

    @Override
    public String toString() {
        return "OwnerEntity{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", netWorth='" + netWorth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age='" + age + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Set<TeamEntity> getTeams() {
        return teams;
    }

    public void setTeams(Set<TeamEntity> teams) {
        this.teams = teams;
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

    public String getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(String netWorth) {
        this.netWorth = netWorth;
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

}
