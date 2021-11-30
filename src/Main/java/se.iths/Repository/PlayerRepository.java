package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.entitys.PlayerEntity;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Long> {
}
