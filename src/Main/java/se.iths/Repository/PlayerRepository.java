package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.entitys.PlayerEntity;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<PlayerEntity, Long> {
    List<PlayerEntity> findByUserName(String name);
}
