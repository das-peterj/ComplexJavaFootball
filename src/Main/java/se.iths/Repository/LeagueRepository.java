package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.entitys.LeagueEntity;

import java.util.List;

@Repository
public interface LeagueRepository extends CrudRepository<LeagueEntity, Long> {
    List<LeagueEntity> findByLeagueName(String name);
}
