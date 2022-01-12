package se.iths.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final FootballUserDetailsService footballUserDetailsService;



    public SecurityConfig(FootballUserDetailsService footballUserDetailsService) {
        this.footballUserDetailsService = footballUserDetailsService;


    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(footballUserDetailsService);
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
                .antMatchers("/home", "/teams", "/players", "/login", "/users/createAdmin/*", "/users").permitAll()
                .antMatchers(
                        "/players/*", "/players/*/*/*",
                        "/managers/*", "/managers/*/*", "/owners/*", "/owners/*/*", "/admin",
                        "/leagues/*", "/leagues/*/*", "/teams/*", "/teams/*/*",
                        "/sponsors/*", "/sponsors/*/*").hasAuthority("ADMIN")

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
