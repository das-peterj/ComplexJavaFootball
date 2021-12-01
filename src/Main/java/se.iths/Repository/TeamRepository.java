package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.entitys.PlayerEntity;
import se.iths.entitys.TeamEntity;

import java.util.List;

@Repository
public interface TeamRepository extends CrudRepository<TeamEntity, Long> {
    List<TeamEntity> findByName(String name);
}
