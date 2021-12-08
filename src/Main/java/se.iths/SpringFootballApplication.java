package se.iths;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import se.iths.Repository.RoleRepository;
import se.iths.entitys.RoleEntity;

@SpringBootApplication(exclude =SecurityAutoConfiguration.class)
public class SpringFootballApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFootballApplication.class, args);
    }


    @Bean
    public CommandLineRunner setUpRole(RoleRepository roleRepository) {
        return (args) -> {

            roleRepository.save(new RoleEntity("ROLE_ADMIN"));
            roleRepository.save(new RoleEntity("ROLE_PLAYER"));
            roleRepository.save(new RoleEntity("ROLE_MANAGER"));
            roleRepository.save(new RoleEntity("ROLE_OWNER"));
        };

    }
}
