package se.iths.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final FootballUserDetailsService footballUserDetailsService;
   // private final PasswordEncoder passwordEncoder;


    public SecurityConfig(FootballUserDetailsService footballUserDetailsService) {
        this.footballUserDetailsService = footballUserDetailsService;
      //  this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public DaoAuthenticationProvider AuthenticationProvider() {
        DaoAuthenticationProvider provider =  new DaoAuthenticationProvider();
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
                .antMatchers("/","/home", "/sponsors", "/leagues","/teams", "/players", "/managers", "/owners").permitAll()
//                .antMatchers("/players", "/players/*", "/players/*/*/*", "/home", "/application").hasRole("PLAYER")
//                .antMatchers(
//                        "/players", "/players/*", "/players/*/*/*",
//                        "/managers", "/managers/*", "/managers/*/*").hasRole("MANAGER")
//                .antMatchers(
//                        "/players", "/players/*", "/players/*/*/*",
//                        "/managers", "/managers/*", "/managers/*/*", "/owners", "/owners/*" , "/owners/*/*", "/admin").hasRole("OWNER")
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


//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return this.passwordEncoder;
//    }
}
