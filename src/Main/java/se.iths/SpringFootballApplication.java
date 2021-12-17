package se.iths;

import org.apache.tomcat.jni.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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


@SpringBootApplication
public class SpringFootballApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFootballApplication.class, args);
    }

    @Bean
    public CommandLineRunner setUpFootball(RoleRepository roleRepository, LeagueRepository leagueRepository,
                                           TeamRepository teamRepository,
                                           ManagerRepository managerRepository,
                                           OwnerRepository ownerRepository,
                                           SponsorRepository sponsorRepository,
                                           PlayerRepository playerRepository, UserRepository userRepository) {
        return (args) -> {

            RoleEntity rolePlayer = new RoleEntity("ROLE_PLAYER");
            RoleEntity roleManager = new RoleEntity("ROLE_MANAGER");
            RoleEntity roleOwner = new RoleEntity("ROLE_OWNER");

            LeagueEntity league1 = new LeagueEntity(1L, "Premier League", "England");
            LeagueEntity league2 = new LeagueEntity(2L, "Bundesliga", "Germany");
            LeagueEntity league3 = new LeagueEntity(3L, "LaLiga", "Spain");

            SponsorEntity sponsor1 =new SponsorEntity(1L, "Nike");
            SponsorEntity sponsor2 =new SponsorEntity(2L, "Adidas");
            SponsorEntity sponsor3 =new SponsorEntity(3L, "Coca");

            OwnerEntity owner1 = new OwnerEntity(1L, "Muharem", "1000000m","891273179","23");
            OwnerEntity owner2 = new OwnerEntity(2L, "Bin Ladin", "727272727m","261532312","69");
            OwnerEntity owner3 = new OwnerEntity(3L, "Sheikh", "96128m", "821765912", "23");

            ManagerEntity manager1 = new ManagerEntity(1L, "Xavi Hernandez", "78623167","41","xavi.barcelona@barcelona.com");
            ManagerEntity manager2 = new ManagerEntity(2L, "Pep Guardiola", "852185190", "49", "pep.city@city.com");
            ManagerEntity manager3 = new ManagerEntity(3L, "Mourinho", "072519251", "55", "morreinho@gmail.com");
            ManagerEntity manager4 = new ManagerEntity(4L, "Luis Enrique", "072519222", "45", "LuisEnrique@gmail.com");
            ManagerEntity manager5 = new ManagerEntity(5L, "Diego Simeone", "0728287322", "50", "DiegoSimeone@gmail.com");
            ManagerEntity manager6 = new ManagerEntity(6L, "Jurgen klopp", "092727371", "49", "jurgenklopp@gmail.com");

            TeamEntity team1 = new TeamEntity(1L,"Arsenal","1580m");
            TeamEntity team2 = new TeamEntity(2L,"Dortmund","2517m");
            TeamEntity team3 = new TeamEntity(3L,"Barcelona","611m");
            TeamEntity team4 = new TeamEntity(4L,"Real Madrid","589m");
            TeamEntity team5 = new TeamEntity(5L, "Bayern Munchen", "691m");
            TeamEntity team6 = new TeamEntity(6L,"Newcastle","8243724m");

            PlayerEntity player1 = new PlayerEntity(1L, "Lionel Messi", "ST","150m");
            PlayerEntity player2 = new PlayerEntity(2L, "Cristiano Ronaldo", "ST","140m");
            PlayerEntity player3 = new PlayerEntity(3L, "Neymar Junior", "LW", "100m");
            PlayerEntity player4 = new PlayerEntity(4L, "Kevin De Bruyne", "CM","50m");
            PlayerEntity player5 = new PlayerEntity(5L, "Mohamed Salah", "RW","70m");
            PlayerEntity player6 = new PlayerEntity(6L, "Alexander Isak", "ST", "20m");
            PlayerEntity player7 = new PlayerEntity(7L, "Victor Lindelöf", "CB", "20m");
            PlayerEntity player8 = new PlayerEntity(8L, "Trent Alexander Arnold", "RB", "77m");
            PlayerEntity player9 = new PlayerEntity(9L, "Manuel Neuer", "GK", "60m");
            PlayerEntity player10 = new PlayerEntity(10L, "Zlatan Ibrahimovic", "ST", "40m");
            PlayerEntity player11 = new PlayerEntity(11L, "Robert Lewandowski", "ST", "110m");
            PlayerEntity player12 = new PlayerEntity(12L, "Andres Iniesta", "CM", "30m");


            player1.addRole(rolePlayer);
            player2.addRole(rolePlayer);
            player3.addRole(rolePlayer);
            player4.addRole(rolePlayer);
            player5.addRole(rolePlayer);
            player6.addRole(rolePlayer);
            player7.addRole(rolePlayer);
            player8.addRole(rolePlayer);
            player9.addRole(rolePlayer);
            player10.addRole(rolePlayer);
            player11.addRole(rolePlayer);
            player12.addRole(rolePlayer);


            player1.setUserName("messi");
            player1.setPassword("barca");


            manager1.addRole(roleManager);
            manager2.addRole(roleManager);
            manager3.addRole(roleManager);
            manager4.addRole(roleManager);
            manager5.addRole(roleManager);
            manager6.addRole(roleManager);

            owner1.addRole(roleOwner);
            owner2.addRole(roleOwner);
            owner3.addRole(roleOwner);

//            rolePlayer.addRoleToPlayer(player1);
//            rolePlayer.addRoleToPlayer(player2);
//            rolePlayer.addRoleToPlayer(player3);
//            rolePlayer.addRoleToPlayer(player4);
//            rolePlayer.addRoleToPlayer(player5);
//            rolePlayer.addRoleToPlayer(player6);
//            rolePlayer.addRoleToPlayer(player7);
//            rolePlayer.addRoleToPlayer(player8);
//            rolePlayer.addRoleToPlayer(player9);
//            rolePlayer.addRoleToPlayer(player10);
//            rolePlayer.addRoleToPlayer(player11);
//            rolePlayer.addRoleToPlayer(player12);

//            roleManager.addRoleToManager(manager1);
//            roleManager.addRoleToManager(manager2);
//            roleManager.addRoleToManager(manager3);
//            roleManager.addRoleToManager(manager4);
//            roleManager.addRoleToManager(manager5);
//            roleManager.addRoleToManager(manager6);
//
//            roleOwner.addRoleToOwner(owner1);
////          roleOwner.addRoleToOwner(owner2);
////          roleOwner.addRoleToOwner(owner3);

            team1.addLeague(league1);
            team2.addLeague(league2);
            team3.addLeague(league3);
            team4.addLeague(league3);
            team5.addLeague(league2);
            team6.addLeague(league1);

            player1.addTeam(team1);
            player2.addTeam(team1);
            player3.addTeam(team2);
            player4.addTeam(team2);
            player5.addTeam(team3);
            player6.addTeam(team3);
            player7.addTeam(team4);
            player8.addTeam(team4);
            player9.addTeam(team5);
            player10.addTeam(team5);
            player11.addTeam(team6);
            player12.addTeam(team6);

            sponsor1.addTeam(team1);
            sponsor2.addTeam(team1);
            sponsor2.addTeam(team2);
            sponsor3.addTeam(team2);
            sponsor3.addTeam(team3);
            sponsor1.addTeam(team3);
            sponsor3.addTeam(team4);
            sponsor3.addTeam(team4);
            sponsor1.addTeam(team5);
            sponsor2.addTeam(team5);
            sponsor3.addTeam(team6);
            sponsor2.addTeam(team6);

            team1.addManager(manager1);
            team2.addManager(manager2);
            team3.addManager(manager3);
            team4.addManager(manager4);
            team5.addManager(manager5);
            team6.addManager(manager6);


            team1.addOwner(owner1);
            team2.addOwner(owner1);
            team3.addOwner(owner2);
            team4.addOwner(owner2);
            team5.addOwner(owner3);
            team6.addOwner(owner3);

            teamRepository.save(team1);
            teamRepository.save(team2);
            teamRepository.save(team3);
            teamRepository.save(team4);
            teamRepository.save(team5);
            teamRepository.save(team6);

            leagueRepository.save(league1);
            leagueRepository.save(league2);
            leagueRepository.save(league3);

            sponsorRepository.save(sponsor1);
            sponsorRepository.save(sponsor2);
            sponsorRepository.save(sponsor3);

            ownerRepository.save(owner1);
            ownerRepository.save(owner2);
            ownerRepository.save(owner3);

            managerRepository.save(manager1);
            managerRepository.save(manager2);
            managerRepository.save(manager3);
            managerRepository.save(manager4);
            managerRepository.save(manager5);
            managerRepository.save(manager6);

            playerRepository.save(player1);
            playerRepository.save(player2);
            playerRepository.save(player3);
            playerRepository.save(player4);
            playerRepository.save(player5);
            playerRepository.save(player6);
            playerRepository.save(player7);
            playerRepository.save(player8);
            playerRepository.save(player9);
            playerRepository.save(player10);
            playerRepository.save(player11);
            playerRepository.save(player12);

            roleRepository.save(roleManager);
            roleRepository.save(rolePlayer);
            roleRepository.save(roleOwner);

        };
    }
}
