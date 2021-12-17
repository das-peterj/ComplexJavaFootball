package se.iths.Repository;

import org.apache.catalina.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.iths.entitys.ManagerEntity;
import se.iths.entitys.PlayerEntity;

import java.util.List;

@Repository
public interface ManagerRepository extends CrudRepository <ManagerEntity, Long> {
  ManagerEntity findByFullName(String fullName);
}
