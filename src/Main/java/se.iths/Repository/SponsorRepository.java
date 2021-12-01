package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.entitys.SponsorEntity;

import java.util.List;

@Repository
public interface SponsorRepository extends CrudRepository<SponsorEntity, Long> {
    List<SponsorEntity> findByName(String name);
}
