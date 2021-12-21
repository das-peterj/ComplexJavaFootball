package se.iths.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import se.iths.Repository.LeagueRepository;
import se.iths.Repository.ManagerRepository;
import se.iths.Repository.OwnerRepository;
import se.iths.Repository.PlayerRepository;
import se.iths.Repository.RoleRepository;
import se.iths.Repository.SponsorRepository;
import se.iths.Repository.TeamRepository;
import se.iths.Repository.UserRepository;
import se.iths.entitys.LeagueEntity;
import se.iths.entitys.ManagerEntity;
import se.iths.entitys.OwnerEntity;
import se.iths.entitys.PlayerEntity;
import se.iths.entitys.SponsorEntity;
import se.iths.entitys.TeamEntity;

import javax.transaction.Transactional;

@Component
public class Sample_DataGeneretor implements ApplicationRunner {

    private LeagueRepository leagueRepository;
    private ManagerRepository managerRepository;
    private OwnerRepository ownerRepository;
    private PlayerRepository playerRepository;
    private RoleRepository roleRepository;
    private SponsorRepository sponsorRepository;
    private TeamRepository teamRepository;
    private UserRepository userRepository;

    @Autowired
    public
        Sample_DataGeneretor(LeagueRepository leagueRepository, ManagerRepository managerRepository, OwnerRepository ownerRepository, PlayerRepository playerRepository, RoleRepository roleRepository, SponsorRepository sponsorRepository, TeamRepository teamRepository, UserRepository userRepository)
        {
            this.leagueRepository = leagueRepository;
            this.managerRepository = managerRepository;
            this.ownerRepository = ownerRepository;
            this.playerRepository = playerRepository;
            this.roleRepository = roleRepository;
            this.sponsorRepository = sponsorRepository;
            this.teamRepository = teamRepository;
            this.userRepository = userRepository;
        }

        @Override
        @Transactional
        public void run (ApplicationArguments args){


            LeagueEntity league1 = new LeagueEntity(1L, "Premier League", "England");
            LeagueEntity league2 = new LeagueEntity(2L, "Bundesliga", "Germany");
            LeagueEntity league3 = new LeagueEntity(3L, "LaLiga", "Spain");

            SponsorEntity sponsor1 = new SponsorEntity(4L, "Nike");
            SponsorEntity sponsor2 = new SponsorEntity(5L, "Adidas");
            SponsorEntity sponsor3 = new SponsorEntity(6L, "Coca");

            OwnerEntity owner1 = new OwnerEntity(7L, "Muharem", "1000000m", "891273179", "23");
            OwnerEntity owner2 = new OwnerEntity(8L, "Bin Ladin", "727272727m", "261532312", "69");
            OwnerEntity owner3 = new OwnerEntity(9L, "Sheikh", "96128m", "821765912", "23");

            ManagerEntity manager1 = new ManagerEntity(10L, "Xavi Hernandez", "78623167", "41", "xavi.barcelona@barcelona.com");
            ManagerEntity manager2 = new ManagerEntity(11L, "Pep Guardiola", "852185190", "49", "pep.city@city.com");
            ManagerEntity manager3 = new ManagerEntity(12L, "Mourinho", "072519251", "55", "morreinho@gmail.com");
            ManagerEntity manager4 = new ManagerEntity(13L, "Luis Enrique", "072519222", "45", "LuisEnrique@gmail.com");
            ManagerEntity manager5 = new ManagerEntity(14L, "Diego Simeone", "0728287322", "50", "DiegoSimeone@gmail.com");
            ManagerEntity manager6 = new ManagerEntity(15L, "Jurgen klopp", "092727371", "49", "jurgenklopp@gmail.com");

            TeamEntity team1 = new TeamEntity(16L, "Arsenal", "1580m");
            TeamEntity team2 = new TeamEntity(17L, "Dortmund", "2517m");
            TeamEntity team3 = new TeamEntity(18L, "Barcelona", "611m");
            TeamEntity team4 = new TeamEntity(19L, "Real Madrid", "589m");
            TeamEntity team5 = new TeamEntity(20L, "Bayern Munchen", "691m");
            TeamEntity team6 = new TeamEntity(21L, "Newcastle", "8243724m");

            PlayerEntity player1 = new PlayerEntity(22L, "Lionel Messi", "ST", "150m");
            PlayerEntity player2 = new PlayerEntity(23L, "Cristiano Ronaldo", "ST", "140m");
            PlayerEntity player3 = new PlayerEntity(24L, "Neymar Junior", "LW", "100m");
            PlayerEntity player4 = new PlayerEntity(25L, "Kevin De Bruyne", "CM", "50m");
            PlayerEntity player5 = new PlayerEntity(26L, "Mohamed Salah", "RW", "70m");
            PlayerEntity player6 = new PlayerEntity(27L, "Alexander Isak", "ST", "20m");
            PlayerEntity player7 = new PlayerEntity(28L, "Victor Lindelof", "CB", "20m");
            PlayerEntity player8 = new PlayerEntity(29L, "Trent-Arnold", "RB", "77m");
            PlayerEntity player9 = new PlayerEntity(30L, "Manuel Neuer", "GK", "60m");
            PlayerEntity player10 = new PlayerEntity(31L, "Zlatan Ibrahimovic", "ST", "40m");
            PlayerEntity player11 = new PlayerEntity(32L, "Robert Lewandowski", "ST", "110m");
            PlayerEntity player12 = new PlayerEntity(33L, "Andres Iniesta", "CM", "30m");

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

            managerRepository.save(manager4);
            managerRepository.save(manager5);
            managerRepository.save(manager6);
            managerRepository.save(manager1);
            managerRepository.save(manager2);
            managerRepository.save(manager3);

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

        }
    }


