package se.iths.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final FootballPlayerDetailsService playerDetailService;
    private final FootballManagerDetailsService managerDetailsService;
    private final FootballOwnerDetailsService ownerDetailsService;

    public SecurityConfig(FootballPlayerDetailsService playerDetailService, FootballOwnerDetailsService ownerDetailsService, FootballManagerDetailsService managerDetailsService) {
        this.playerDetailService = playerDetailService;
        this.ownerDetailsService = ownerDetailsService;
        this.managerDetailsService = managerDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider =  new DaoAuthenticationProvider();
      //  provider.setUserDetailsService(playerDetailService);
      //  provider.setUserDetailsService(managerDetailsService);
        provider.setUserDetailsService(ownerDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/","/sponsors", "/leagues","/teams", "/players", "/managers", "/owners").permitAll()
//                .antMatchers("/players", "/players/*", "/players/*/*/*").hasRole("PLAYER")
//                .antMatchers(
//                        "/players", "/players/*", "/players/*/*/*",
//                        "/managers", "/managers/*", "/managers/*/*").hasRole("MANAGER")
//                .antMatchers(
//                        "/players", "/players/*", "/players/*/*/*",
//                        "/managers", "/managers/*", "/managers/*/*", "/owners", "/owners/*" , "/owners/*/*").hasRole("OWNER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll();
    }
}
