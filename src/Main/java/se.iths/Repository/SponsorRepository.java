package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import se.iths.entitys.SponsorEntity;

public interface SponsorRepository extends CrudRepository<SponsorEntity, Long> {
}
