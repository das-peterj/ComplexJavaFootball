package se.iths.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.entitys.LeagueEntity;

@Repository
public interface LeagueRepository extends CrudRepository<LeagueEntity, Long> {
}
