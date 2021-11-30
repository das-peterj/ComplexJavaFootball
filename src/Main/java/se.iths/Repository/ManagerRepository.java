package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.entitys.ManagerEntity;

@Repository
public interface ManagerRepository extends CrudRepository <ManagerEntity, Long> {
}
