package se.iths.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.entitys.OwnerEntity;
import java.util.List;
@Repository
public interface OwnerRepository extends CrudRepository <OwnerEntity, Long> {
    List <OwnerEntity> findByFullName(String userName);
}
