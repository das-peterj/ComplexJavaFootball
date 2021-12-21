package se.iths.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.iths.Repository.RoleRepository;
import se.iths.entitys.RoleEntity;

import javax.management.relation.Role;
import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleEntity createRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    public List<RoleEntity> getRoles() {
        return roleRepository.findAll();
    }
}