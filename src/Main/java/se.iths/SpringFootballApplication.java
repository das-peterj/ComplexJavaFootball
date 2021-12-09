package se.iths;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import se.iths.Repository.LeagueRepository;
import se.iths.Repository.ManagerRepository;
import se.iths.Repository.OwnerRepository;
import se.iths.Repository.PlayerRepository;
import se.iths.Repository.RoleRepository;
import se.iths.Repository.SponsorRepository;
import se.iths.Repository.TeamRepository;
import se.iths.entitys.LeagueEntity;
import se.iths.entitys.ManagerEntity;
import se.iths.entitys.OwnerEntity;
import se.iths.entitys.PlayerEntity;
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
    public CommandLineRunner setUpFootball(LeagueRepository leagueRepository,
                                           TeamRepository teamRepository,
                                           ManagerRepository managerRepository,
                                           OwnerRepository ownerRepository,
                                           SponsorRepository sponsorRepository,
                                           PlayerRepository playerRepository) {
        return (args) -> {

            LeagueEntity league1 = new LeagueEntity(1L, "Premier League", "England");
            LeagueEntity league2 = new LeagueEntity(2L, "Bundesliga", "Germany");
            LeagueEntity league3 = new LeagueEntity(3L, "LaLiga", "Spain");

            SponsorEntity sponsor1 =new SponsorEntity(1L, "Nike");
            SponsorEntity sponsor2 =new SponsorEntity(2L, "Adidas");
            SponsorEntity sponsor3 =new SponsorEntity(3L, "Coca");

            OwnerEntity owner1 = new OwnerEntity(1L, "Muharem", "1000000m","891273179","23","BigOwner","qwe");
            OwnerEntity owner2 = new OwnerEntity(2L, "Bin Ladin", "727272727m","261532312","69","BinLadin","weapons");
            OwnerEntity owner3 = new OwnerEntity(3L, "Sheikh", "96128m", "821765912", "23", "sheikoil", "oil");

            ManagerEntity manager1 = new ManagerEntity(1L, "Xavi Hernandez", "78623167","41","xavi.barcelona@barcelona.com","xavi","brain");
            ManagerEntity manager2 = new ManagerEntity(2L, "Pep Guardiola", "852185190", "49", "pep.city@city.com", "pep", "guard");
            ManagerEntity manager3 = new ManagerEntity(3L, "Mourinho", "072519251", "55", "morreinho@gmail.com", "morre", "roma");
            ManagerEntity manager4 = new ManagerEntity(3L, "Luis Enrique", "072519222", "45", "LuisEnrique@gmail.com", "LuisQ", "Spain321");
            ManagerEntity manager5 = new ManagerEntity(3L, "Diego Simeone", "0728287322", "50", "DiegoSimeone@gmail.com", "Diegoooo", "Athelticoooo");
            ManagerEntity manager6 = new ManagerEntity(3L, "Jurgen klopp", "092727371", "49", "jurgenklopp@gmail.com", "JurgenLiv", "klopp-pool");



            TeamEntity team1 = new TeamEntity(1L,"Arsenal","1580m");
            TeamEntity team2 = new TeamEntity(2L,"Dortmund","2517m");
            TeamEntity team3 = new TeamEntity(3L,"Barcelona","611m");
            TeamEntity team4 = new TeamEntity(4L,"Real Madrid","589m");
            TeamEntity team5 = new TeamEntity(5L, "Bayern Munchen", "691m");
            TeamEntity team6 = new TeamEntity(6L,"Newcastle","8243724m");


            PlayerEntity player1 = new PlayerEntity(1L, "Lionel Messi", "ST","150m","lionelmessi","psg");
            PlayerEntity player2 = new PlayerEntity(2L, "Cristiano Ronaldo", "ST","140m","c.ronaldo","manU");
            PlayerEntity player3 = new PlayerEntity(3L, "Neymar Junior", "LW", "100m", "NeymarJR", "psg123");
            PlayerEntity player4 = new PlayerEntity(4L, "Kevin De Bruyne", "CM","50m","KevinBruy","Bruyneee");
            PlayerEntity player5 = new PlayerEntity(5L, "Mohamed Salah", "RW","70m","MohamedS","Salah123");
            PlayerEntity player6 = new PlayerEntity(6L, "Alexander Isak", "ST", "20m", "Alexandeeer", "IsakA");
            PlayerEntity player7 = new PlayerEntity(7L, "Victor Lindelöf", "CB", "20m", "lindanlof", "sverigekapten");
            PlayerEntity player8 = new PlayerEntity(8L, "Trent Alexander Arnold", "RB", "77m", "klopp", "livapool");
            PlayerEntity player9 = new PlayerEntity(9L, "Manuel Neuer", "GK", "60m", "neuerrrr", "bayernmia");
            PlayerEntity player10 = new PlayerEntity(11L, "Zlatan Ibrahimovic", "ST", "40m", "malmoezlatan", "zlattan");
            PlayerEntity player11 = new PlayerEntity(12L, "Robert Lewandowski", "ST", "110m", "lewangoalski", "miasanmia");
            PlayerEntity player12 = new PlayerEntity(13L, "Andres Iniesta", "CM", "30m", "iniadres", "barca");


            team1.addLeague(league1);
            team2.addLeague(league2);
            team3.addLeague(league3);
            team4.addLeague(league3);
            team5.addLeague(league2);
            team6.addLeague(league1);

            team1.addPlayer(player1);
//            team1.addPlayer(player12);
//            team2.addPlayer(player2);
//            team2.addPlayer(player11);
//            team3.addPlayer(player3);
//            team3.addPlayer(player10);
//            team4.addPlayer(player4);
//            team4.addPlayer(player9);
//            team5.addPlayer(player5);
//            team5.addPlayer(player8);
//            team6.addPlayer(player6);
//            team6.addPlayer(player7);

//            team1.addSponsor(sponsor1);
////            team1.addSponsor(sponsor3);
//            team2.addSponsor(sponsor2);
//            team3.addSponsor(sponsor1);
////            team3.addSponsor(sponsor2);
//            team4.addSponsor(sponsor3);
//            team5.addSponsor(sponsor2);
////            team6.addSponsor(sponsor1);
//            team6.addSponsor(sponsor3);

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

//            sponsorRepository.save(sponsor1);
//            sponsorRepository.save(sponsor2);
//            sponsorRepository.save(sponsor3);

            ownerRepository.save(owner1);
            ownerRepository.save(owner2);
            ownerRepository.save(owner3);

            managerRepository.save(manager1);
            managerRepository.save(manager2);
            managerRepository.save(manager3);
            managerRepository.save(manager4);
            managerRepository.save(manager5);
            managerRepository.save(manager6);

            // playerRepository.save(player1);
//            playerRepository.save(player2);
//            playerRepository.save(player3);
//            playerRepository.save(player4);
//            playerRepository.save(player5);
//            playerRepository.save(player6);
//            playerRepository.save(player7);
//            playerRepository.save(player8);
//            playerRepository.save(player9);
//            playerRepository.save(player10);
//            playerRepository.save(player11);
//            playerRepository.save(player12);

        };
    }

//    @Bean
//    public CommandLineRunner setUpTeams(TeamRepository teamRepository) {
//        return (args) -> {
//
//            teamRepository.save( new TeamEntity(1L,"Arsenal","1580m"));
//            teamRepository.save(new TeamEntity(2L,"Dortmund","2517m"));
//            teamRepository.save(new TeamEntity(3L,"Barcelona","611m"));
//            teamRepository.save(new TeamEntity(4L,"Real Madrid","589m"));
//            teamRepository.save(new TeamEntity(5L, "Bayern Munchen", "691m"));
//            teamRepository.save(new TeamEntity(6L,"Newcastle","8243724m"));
//        };
//    }

//    @Bean
//    public CommandLineRunner setUpManager(ManagerRepository managerRepository) {
//        return (args) -> {
//
//            managerRepository.save(new ManagerEntity(1L, "Xavi Hernandez", "78623167","41","xavi.barcelona@barcelona.com","xavi","brain"));
//            managerRepository.save(new ManagerEntity(2L, "Pep Guardiola", "852185190", "49", "pep.city@city.com", "pep", "guard"));
//            managerRepository.save(new ManagerEntity(3L, "Mourinho", "072519251", "55", "morreinho@gmail.com", "morre", "roma"));
//        };
//    }
//
//    @Bean
//    public CommandLineRunner setUpOwner(OwnerRepository ownerRepository) {
//        return (args) -> {
//
//            ownerRepository.save(new OwnerEntity(1L, "Muharem", "1000000m","891273179","23","BigOwner","qwe"));
//            ownerRepository.save(new OwnerEntity(2L, "Bin Ladin", "727272727m","261532312","69","BinLadin","weapons"));
//            ownerRepository.save(new OwnerEntity(3L, "Sheikh", "96128m", "821765912", "23", "sheikoil", "oil"));
//        };
//    }
//
//    @Bean
//    public CommandLineRunner setUpSponsor(SponsorRepository sponsorRepository) {
//        return (args) -> {
//
//            sponsorRepository.save(new SponsorEntity(1L, "Nike"));
//            sponsorRepository.save(new SponsorEntity(2L, "Adidas"));
//            sponsorRepository.save(new SponsorEntity(3L, "Coca Cola"));
//        };
//    }
//
//    @Bean
//    public CommandLineRunner setUpPlayer(PlayerRepository playerRepository){
//        return (args) -> {
//
//
//
//            PlayerEntity player1 = new PlayerEntity(1L, "Lionel Messi", "ST","150m","lionelmessi","psg");
//            playerRepository.save(new PlayerEntity(2L, "Cristiano Ronaldo", "ST","140m","c.ronaldo","manU"));
//            playerRepository.save(new PlayerEntity(3L, "Neymar Junior", "LW", "100m", "NeymarJR", "psg123"));
//            playerRepository.save(new PlayerEntity(4L, "Kevin De Bruyne", "CM","50m","KevinBruy","Bruyneee"));
//            playerRepository.save(new PlayerEntity(5L, "Mohamed Salah", "RW","70m","MohamedS","Salah123"));
//            playerRepository.save(new PlayerEntity(6L, "Alexander Isak", "ST", "20m", "Alexandeeer", "IsakA"));
//            playerRepository.save(new PlayerEntity(7L, "Victor Lindelöf", "CB", "20m", "lindanlof", "sverigekapten"));
//            playerRepository.save(new PlayerEntity(8L, "Trent Alexander Arnold", "RB", "77m", "klopp", "livapool"));
//            playerRepository.save(new PlayerEntity(9L, "Manuel Neuer", "GK", "60m", "neuerrrr", "bayernmia"));
//            playerRepository.save(new PlayerEntity(11L, "Zlatan Ibrahimovic", "ST", "40m", "malmoezlatan", "zlattan"));
//            playerRepository.save(new PlayerEntity(12L, "Robert Lewandowski", "ST", "110m", "lewangoalski", "miasanmia"));
//            playerRepository.save(new PlayerEntity(13L, "Andres Iniesta", "CM", "30m", "iniadres", "barca"));
//
//
//        };
//    }

}
