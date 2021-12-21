package se.iths.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class RoleEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role;


    @ManyToMany(mappedBy = "roles")
    @Getter(onMethod_ = @JsonIgnore)
    private Set<UserEntity> users;


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

}
