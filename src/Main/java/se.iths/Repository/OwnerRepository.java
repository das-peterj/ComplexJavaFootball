package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import se.iths.entitys.OwnerEntity;

@Repository
public interface OwnerRepository extends CrudRepository <OwnerEntity, Long> {
}
