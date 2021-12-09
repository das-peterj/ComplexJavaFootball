package se.iths;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import se.iths.Repository.LeagueRepository;
import se.iths.Repository.ManagerRepository;
import se.iths.Repository.OwnerRepository;
import se.iths.Repository.RoleRepository;
import se.iths.Repository.SponsorRepository;
import se.iths.Repository.TeamRepository;
import se.iths.entitys.LeagueEntity;
import se.iths.entitys.ManagerEntity;
import se.iths.entitys.OwnerEntity;
import se.iths.entitys.RoleEntity;
import se.iths.entitys.SponsorEntity;
import se.iths.entitys.TeamEntity;


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

    @Bean
    public CommandLineRunner setUpLeague(LeagueRepository leagueRepository) {
        return (args) -> {

        leagueRepository.save(new LeagueEntity(1L, "Premier League", "England"));
        leagueRepository.save(new LeagueEntity(2L, "Bundesliga", "Germany"));
        leagueRepository.save(new LeagueEntity(3L, "LaLiga", "Spain"));
        };
    }

    @Bean
    public CommandLineRunner setUpTeams(TeamRepository teamRepository) {
        return (args) -> {

            teamRepository.save( new TeamEntity(1L,"Arsenal","1580m"));
            teamRepository.save(new TeamEntity(2L,"Dortmund","2517m"));
            teamRepository.save(new TeamEntity(3L,"Barcelona","611m"));
            teamRepository.save(new TeamEntity(4L,"Real Madrid","589m"));
            teamRepository.save(new TeamEntity(5L, "Bayern Munchen", "691m"));
            teamRepository.save(new TeamEntity(6L,"Newcastle","8243724m"));
        };
    }

    @Bean
    public CommandLineRunner setUpManager(ManagerRepository managerRepository) {
        return (args) -> {

            managerRepository.save(new ManagerEntity(1L, "Xavi Hernandez", "78623167","41","xavi.barcelona@barcelona.com","xavi","brain"));
            managerRepository.save(new ManagerEntity(2L, "Pep Guardiola", "852185190", "49", "pep.city@city.com", "pep", "guard"));
            managerRepository.save(new ManagerEntity(3L, "Mourinho", "072519251", "55", "morreinho@gmail.com", "morre", "roma"));
        };
    }

    @Bean
    public CommandLineRunner setUpOwner(OwnerRepository ownerRepository) {
        return (args) -> {

            ownerRepository.save(new OwnerEntity(1L, "Muharem", "1000000m","891273179","23","BigOwner","qwe"));
            ownerRepository.save(new OwnerEntity(2L, "Bin Ladin", "727272727m","261532312","69","BinLadin","weapons"));
            ownerRepository.save(new OwnerEntity(3L, "Sheikh", "96128m", "821765912", "23", "sheikoil", "oil"));
        };
    }

    @Bean
    public CommandLineRunner setUpSponsor(SponsorRepository sponsorRepository) {
        return (args) -> {

            sponsorRepository.save(new SponsorEntity(1L, "Nike"));
            sponsorRepository.save(new SponsorEntity(2L, "Adidas"));
            sponsorRepository.save(new SponsorEntity(3L, "Coca Cola"));
        };
    }



}
