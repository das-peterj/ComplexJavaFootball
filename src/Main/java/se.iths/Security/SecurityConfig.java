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

    public SecurityConfig(FootballPlayerDetailsService playerDetailService) {
        this.playerDetailService = playerDetailService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider =  new DaoAuthenticationProvider();
        provider.setUserDetailsService(playerDetailService);
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
                .antMatchers("/", "/leagues","/teams", "/players", "/managers", "/owners").permitAll()
                .antMatchers( "/sponsors", "/sponsors/*", "/sponsors/*/*/*").permitAll()
                .antMatchers( "/teams", "/teams/*", "/teams/*/*/*").permitAll()
//                .antMatchers("/player").hasRole("PLAYER")
//                .antMatchers("/manager").hasRole("MANAGER")
//                .antMatchers("/owner").hasRole("OWNER")
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
