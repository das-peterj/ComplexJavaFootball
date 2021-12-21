package se.iths.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class OwnerEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String netWorth;
    private String phoneNumber;
    private String age;


    @OneToMany(mappedBy = "owners", cascade = CascadeType.ALL)
    private Set<TeamEntity> teams = new HashSet<>();

    public OwnerEntity(Long id, String fullName, String netWorth, String phoneNumber, String age) {
        this.id = id;
        this.fullName = fullName;
        this.netWorth = netWorth;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
    public OwnerEntity() {
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



}
