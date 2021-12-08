
package se.iths.Security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import se.iths.entitys.PlayerEntity;
import se.iths.entitys.RoleEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class FootballPlayerPrincipal implements UserDetails {

    private PlayerEntity playerEntity;

    public FootballPlayerPrincipal(PlayerEntity playerEntity) {
        super();
        this.playerEntity = playerEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<RoleEntity> roles = playerEntity.getRoles();
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles.size());

        for (RoleEntity role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().toUpperCase()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
