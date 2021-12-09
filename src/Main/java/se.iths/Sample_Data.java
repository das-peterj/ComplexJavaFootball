//package se.iths;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//import se.iths.entitys.LeagueEntity;
//import se.iths.Repository.LeagueRepository;
//import se.iths.Repository.ManagerRepository;
//import se.iths.Repository.PlayerRepository;
//import se.iths.Repository.OwnerRepository;
//import se.iths.Repository.SponsorRepository;
//import se.iths.Repository.TeamRepository;
//import se.iths.entitys.TeamEntity;
//
//import javax.annotation.PostConstruct;
//
//@Component
//public class Sample_Data implements ApplicationListener<ApplicationReadyEvent> {
//
//
//    @Autowired
//    private final DbSampleAdditor db;
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
//        db.addSample_Data();
//    }
//
//
//    @Autowired
//    private LeagueRepository leagueRepository;
//    private ManagerRepository managerRepository;
//    private PlayerRepository playerRepository;
//    private OwnerRepository ownerRepository;
//    private SponsorRepository sponsorRepository;
//    private TeamRepository teamRepository;
//
//
//
//    @PostConstruct
//    private void postConstruct() {
//
//        LeagueEntity league1 = new LeagueEntity(1L, "Premier League", "England");
//        LeagueEntity league2 = new LeagueEntity(2L, "Bundesliga", "Germany");
//        LeagueEntity league3 = new LeagueEntity(3L, "LaLiga", "Spain");
//
//        TeamEntity team1 = new TeamEntity(1L,"Arsenal","1580m");
//        TeamEntity team2 = new TeamEntity(1L,"Dortmund","2517m");
//        TeamEntity team3 = new TeamEntity(1L,"Barcelona","611m");
//        TeamEntity team4 = new TeamEntity(1L,"Real Madrid","589m");
//        TeamEntity team5 = new TeamEntity(1L,"Bayern Munchen","2321m");
//        TeamEntity team6 = new TeamEntity(6L,"Newcastle","8243724m");
//
//        leagueRepository.save(league1);
//        leagueRepository.save(league2);
//        leagueRepository.save(league3);
//
//        teamRepository.save(team1);
//        teamRepository.save(team2);
//        teamRepository.save(team3);
//        teamRepository.save(team4);
//        teamRepository.save(team5);
//        teamRepository.save(team6);
//
//    }
//
//
//
//
//}
