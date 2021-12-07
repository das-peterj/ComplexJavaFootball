package se.iths.entitys;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class SponsorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "sponsors")
    private List<TeamEntity> teamEntities;

    public SponsorEntity(){}
    /*@ManyToMany(mappedBy = "sponsors")
    private Set<TeamEntity> teamEntities;

    public Set<TeamEntity> getTeamEntities() {
        return teamEntities;
    }
    */


    public void setTeamEntities(TeamEntity teamEntity) {
        }
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


}
