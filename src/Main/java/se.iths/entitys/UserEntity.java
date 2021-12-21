package se.iths.entitys;

import javax.persistence.*;
import java.util.Set;


@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String userName;
    private String password;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<RoleEntity> roles;

    public UserEntity() {

    }
    public void addRole(RoleEntity role){
        this.roles.add(role);
        role.getUsers().add(this);
    }
    public void removeRole(RoleEntity role){
        this.roles.remove(role);
        role.getUsers().remove(this);
    }

    public UserEntity( String name, String userName, String password, Set<RoleEntity> roles) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
