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


    public void addOwner(TeamEntity foundTeam) {
    }
}
