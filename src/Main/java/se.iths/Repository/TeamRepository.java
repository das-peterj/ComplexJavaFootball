package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.entitys.TeamEntity;

@Repository
public interface TeamRepository extends CrudRepository<TeamEntity, Long> {
}
