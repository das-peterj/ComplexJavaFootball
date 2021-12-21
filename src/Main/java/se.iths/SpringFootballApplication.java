package se.iths;

import org.apache.tomcat.jni.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import se.iths.Controller.SponsorController;
import se.iths.Repository.UserRepository;
import se.iths.Repository.LeagueRepository;
import se.iths.Repository.RoleRepository;
import se.iths.Repository.OwnerRepository;
import se.iths.Repository.ManagerRepository;
import se.iths.Repository.PlayerRepository;
import se.iths.Repository.SponsorRepository;
import se.iths.Repository.TeamRepository;
import se.iths.entitys.LeagueEntity;
import se.iths.entitys.ManagerEntity;
import se.iths.entitys.OwnerEntity;
import se.iths.entitys.PlayerEntity;
import se.iths.entitys.RoleEntity;
import se.iths.entitys.SponsorEntity;
import se.iths.entitys.TeamEntity;
import se.iths.entitys.UserEntity;
import se.iths.services.RoleService;
import se.iths.services.UserService;

import javax.transaction.Transactional;
import java.util.HashSet;


@SpringBootApplication
@Transactional
public class SpringFootballApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFootballApplication.class, args);
    }
    @Bean
    public CommandLineRunner setUpRole(UserService userService, RoleService roleService){
        return (args) -> {
            roleService.createRole(new RoleEntity("ADMIN"));
            roleService.createRole(new RoleEntity("USER"));


            userService.createUser(new UserEntity("Muharem", "murre", "1234", new HashSet<>()));
            userService.createUser(new UserEntity("Peter", "pette", "1234",new HashSet<>()));
            userService.createUser(new UserEntity("Oscar", "ogge", "1234", new HashSet<>()));

            userService.addRoleToUser("Muharem", "ADMIN");
            userService.addRoleToUser("Peter", "USER");
            userService.addRoleToUser("Oscar", "USER");
        };
    }
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
